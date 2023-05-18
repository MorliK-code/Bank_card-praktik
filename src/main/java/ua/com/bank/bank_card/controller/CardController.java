package ua.com.bank.bank_card.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.service.CardService;


import java.util.List;


@Controller
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/editcards")
    public String getPageCard(Model model) {
        List<Card> cardList = cardService.getAllCard();
        model.addAttribute("allCard", cardList);
        return "editcards";
    }

    @PostMapping("addCards")
    public String saveNewCardsToBD(@RequestParam("number") String number, @RequestParam("cvc") int cvc, @RequestParam("month") int month, @RequestParam("year") int year) {
        cardService.saveCard(number, cvc, month, year);
        return "redirect:/editcards";
    }

    @PostMapping("updateCards")
    public String updateCards(@RequestParam("cvc") int cvc,
                              @RequestParam("block") boolean block) {
        cardService.updateCard(cvc, block);
        return "redirect:/editcards";
    }
    @PostMapping("updateCardState")
    public String updateCard(@RequestParam("cardId") Long cardId) {
        cardService.updateCardState(cardId);
        return "redirect:/editcards";
    }

    @PostMapping("deleteCard")
    public String deleteCard(@RequestParam("id") Long id) {
        cardService.deleteCard(id);
        return "redirect:/editcards";
    }
}