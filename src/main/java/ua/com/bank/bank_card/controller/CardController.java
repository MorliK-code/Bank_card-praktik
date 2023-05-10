package ua.com.bank.bank_card.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.service.CardService;



import java.util.List;

@Controller
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService){
        this.cardService = cardService;
    }
    @GetMapping("/working")
    public String getPageCard(Model model){

        List<Card> cardList = cardService.getAllCard();
        model.addAttribute(  "allCard", cardList);

        return "work";
    }
}