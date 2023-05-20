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

    private final PaymentRepository paymentRepository;
    private final CardRepository cardRepository;
    private final PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, CardRepository cardRepository, PaymentHistoryRepository paymentHistoryRepository) {
        this.paymentRepository = paymentRepository;
        this.cardRepository = cardRepository;
        this.paymentHistoryRepository = paymentHistoryRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public List<Object[]> getAllPaymentHistory() {
        return paymentHistoryRepository.getAllPaymentHistory();
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

// Сохранение информации о платеже
        paymentRepository.save(payment);

        PaymentHistory paymentHistory = new PaymentHistory();
        paymentHistory.setPayment(payment);

        if (senderCard == null || recipientCard == null) {
            // Одна из карт не найдена
            paymentHistory.setStatus("errorUnknown");
            return "/work?errorUnknown";
        } else if (senderCard.isBlock()) {
            // Карта отправителя заблокирована
            paymentHistory.setStatus("errorBlock");
            return "/work?errorBlock";
        } else if (senderCard.getBalance() < amount) {
            // Недостаточно средств на балансе отправителя
            paymentHistory.setStatus("errorBalance");
            return "/work?errorBalance";
        } else {
            // Успешный платеж
            paymentHistory.setStatus("Completed");
        }

// Сохранение информации о платеже в истории
        paymentHistoryRepository.save(paymentHistory);

// Обновление информации о балансе карт
        cardRepository.save(senderCard);
        cardRepository.save(recipientCard);

        return "redirect:/work?success";

    }

    public boolean isCardBlocked(String cardNumber) {
        Card card = cardRepository.findByNumber(cardNumber);
        return card != null && card.isBlock();
    }
}
