package ua.com.bank.bank_card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.entity.Payment;
import ua.com.bank.bank_card.entity.PaymentHistory;
import ua.com.bank.bank_card.repository.CardRepository;
import ua.com.bank.bank_card.repository.PaymentHistoryRepository;
import ua.com.bank.bank_card.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    private final CardRepository cardRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    public PaymentService(CardRepository cardRepository, PaymentRepository paymentRepository,PaymentHistoryRepository paymentHistoryRepository) {
        this.cardRepository = cardRepository;
        this.paymentRepository = paymentRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    public List<PaymentHistory> getAllPaymentHistory() {
        List<PaymentHistory> paymentHistoryList = paymentHistoryRepository.findAll();

        for (PaymentHistory paymentHistory : paymentHistoryList) {
            Payment payment = paymentHistory.getPayment();
            if (payment != null) {
                boolean isSuccess = checkPaymentSuccess(payment);
                paymentHistory.setStatus(isSuccess ? "Помилка" : "Успішно");
            }
        }

        return paymentHistoryList;
    }

    private boolean checkPaymentSuccess(Payment payment) {
        // Получение статуса платежа из объекта Payment или другого источника данных
        String paymentStatus = payment.getStatus();

        // Проверка статуса платежа и возврат результата
        return paymentStatus.equals("Успішно");
    }

    public String makePayment(String senderNumber, String recipientNumber, double amount) {
        Card senderCard = cardRepository.findByNumber(senderNumber);
        Card recipientCard = cardRepository.findByNumber(recipientNumber);

        if (senderCard == null || recipientCard == null) {
            // Одна из карт не найдена
            return "redirect:/work?errorUnknown";
        }

        if (senderCard.isBlock()) {
            // Карта отправителя заблокирована
            return "redirect:/work?errorBlock";
        }

        if (senderCard.getBalance() < amount) {
            // Недостаточно средств на балансе отправителя
            return "redirect:/work?errorBalance";
        }

        senderCard.setBalance(senderCard.getBalance() - amount);
        recipientCard.setBalance(recipientCard.getBalance() + amount);

        // Создание платежа
        Payment payment = new Payment();
        payment.setSenderNumber(senderNumber);
        payment.setRecipientNumber(recipientNumber);
        payment.setAmount(amount);
        payment.setCard(senderCard);
        payment.setStatus("В обробці");

        // Сохранение информации о платеже
        Payment savedPayment = paymentRepository.save(payment);

        // Создание записи в истории платежей
        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setPayment(savedPayment);

        // Сохранение информации о платеже в истории
        paymentHistoryRepository.save(paymentHistory);

        // Обновление информации о балансе карт
        cardRepository.save(senderCard);
        cardRepository.save(recipientCard);

        return "redirect:/work?success";
    }
}
