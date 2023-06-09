package ua.com.bank.bank_card.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.bank.bank_card.entity.Account;
import ua.com.bank.bank_card.entity.Card;
import ua.com.bank.bank_card.repository.AccountRepository;
import ua.com.bank.bank_card.repository.CardRepository;
import ua.com.bank.bank_card.repository.PaymentRepository;

import java.util.List;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public CardService(CardRepository cardRepository, AccountRepository accountRepository, PaymentRepository paymentRepository){
        this.cardRepository = cardRepository;
        this.accountRepository = accountRepository;
        this.paymentRepository = paymentRepository;
    }

    public List<Card> getAllCard(){
        return cardRepository.findAll();
    }

    public Card saveCard(String number, int cvc, int month, int year) {
        Card card = new Card();
        card.setNumber(number);
        card.setCvc(cvc);
        card.setMonth(month);
        card.setYear(year);

        Account account = new Account();
        account.setNumber(number);
        account.setBlocked(card.isBlock());
        accountRepository.save(account);

        card.setAccount(account);
        Card savedCard = cardRepository.save(card);

        return savedCard;
    }


    public Card updateCard(boolean block){
        Card card = new Card();
        card.setBlock(block);
        Card card1 = cardRepository.save(card);
        return card1;
    }
    public void updateBalance(Long cardId, double newBalance) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid card ID: " + cardId));

        Account account = card.getAccount();
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    @Transactional
    public void deleteCard(Long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Неверный идентификатор карты: " + id));

        // Удаление платежей, связанных с картой
        paymentRepository.deleteByCardId(card.getId());

        cardRepository.delete(card);
    }

    public void updateCardState(Long cardId, Long accountId) {
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid card ID: " + cardId));
        card.setBlock(!card.isBlock());

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid account ID: " + accountId));
        account.setBlocked(card.isBlock());

        cardRepository.save(card);
        accountRepository.save(account);
    }


    public List<Card> getCardList(){
        return cardRepository.findAll();
    }
}
