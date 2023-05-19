package ua.com.bank.bank_card.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data

@Entity
@Table(name = "account_client")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private boolean blocked = false;
    private double balance = 0.0;

    @OneToMany(mappedBy = "account")
    private List<Card> cards;

    public void setCards(List<Card> cards) {
        this.cards = cards;
        for (Card card : cards) {
            card.setAccount(this);
            this.setNumber(card.getNumber());
            this.setBlocked(card.isBlock());
        }
    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
