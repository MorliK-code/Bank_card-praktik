package ua.com.bank.bank_card.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.service.CardService;

import java.util.List;

@Controller
public class WorkController {
    private final CardService cardService;

    public WorkController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/work")
    public String getPageWork(Model model) {
        List<Card> cardList = cardService.getAllCard();
        model.addAttribute("allCard", cardList);
        return "work";
    }
}