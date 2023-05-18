package ua.com.bank.bank_card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.repository.CardRepository;


import java.util.List;
import java.util.Optional;

@Service
public class CardService {


    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCard(){
        return cardRepository.findAll();
    }

    public Card saveCard(String number, int cvc, int month, int year){
        Card card = new Card();
        card.setNumber(number);
        card.setCvc(cvc);
        card.setMonth(month);
        card.setYear(year);
        Card card1 = cardRepository.save(card);
        return card1;
    }

    public Card updateCard(int cvc, boolean block){
        Card card = new Card();
        card.setCvc(cvc);
        card.setBlock(block);
        Card card1 = cardRepository.save(card);
        return card1;
    }
    public void deleteCard(Long id){
        cardRepository.deleteById(id);
    }
    public void updateCardState(Long cardId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid card ID: " + cardId));
        card.setBlock(!card.isBlock());
        cardRepository.save(card);
    }
    public List<Card> getCardList(){
        return cardRepository.findAll();
    }
}
