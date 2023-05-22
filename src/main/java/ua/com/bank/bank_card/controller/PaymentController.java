package ua.com.bank.bank_card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.entity.PaymentHistory;
import ua.com.bank.bank_card.repository.CardRepository;
import ua.com.bank.bank_card.service.PaymentService;

import java.util.List;

@Controller
public class PaymentController {

    private final PaymentService paymentService;
    private final CardRepository cardRepository;

    @Autowired
    public PaymentController(PaymentService paymentService, CardRepository cardRepository) {
        this.paymentService = paymentService;
        this.cardRepository = cardRepository;
    }

    @PostMapping("/payments")
    public String makePayment(@RequestParam("senderNumber") String senderNumber,
                              @RequestParam("recipientNumber") String recipientNumber,
                              @RequestParam("amount") double amount) {
        boolean senderCardExists = cardRepository.existsByNumber(senderNumber);
        boolean recipientCardExists = cardRepository.existsByNumber(recipientNumber);

        if (!senderCardExists || !recipientCardExists) {
            return "redirect:/work?errorUnknownCards";
        }

        Card senderCard = cardRepository.findByNumber(senderNumber);
        Card recipientCard = cardRepository.findByNumber(recipientNumber);

        if (senderCard.isBlock()) {
            // Карта отправителя заблокирована
            return "redirect:/work?errorBlock";
        }

        if (senderCard.getBalance() < amount) {
            // Недостаточно средств на балансе отправителя
            return "redirect:/work?errorBalance";
        }

        paymentService.makePayment(senderNumber, recipientNumber, amount);

        return "redirect:/work?success";
    }

    @GetMapping("/paymenthistory")
    public String viewPaymentHistory(Model model) {
        List<PaymentHistory> paymentHistory = paymentService.getAllPaymentHistory();
        model.addAttribute("paymentHistory", paymentHistory);
        return "paymenthistory";
    }
}
