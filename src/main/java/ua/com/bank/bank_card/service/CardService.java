package ua.com.bank.bank_card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.repository.CardRepository;

import java.util.List;

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

    public Card saveCard(Long id, String number, int cvc, int month, int year){
        Card card = new Card();
        card.setId(id);
        card.setNumber(number);
        card.setCvc(cvc);
        card.setMonth(month);
        card.setYear(year);
        Card card1 = cardRepository.save(card);
        return card1;
    }

    public Card updateCard(Long id, String number, int cvc, int month, int year){
        Card card = new Card();
        card.setId(id);
        card.setNumber(number);
        card.setCvc(cvc);
        card.setMonth(month);
        card.setYear(year);
        Card card1 = cardRepository.save(card);
        return card1;
    }

    public Card deleteCard(Long id){
        cardRepository.deleteById(id);
        return null;
    }
    public void deleteAllCard(){
        cardRepository.deleteAll();
    }
    public List<Card> getCardList(){
        return cardRepository.findAll();
    }

}
