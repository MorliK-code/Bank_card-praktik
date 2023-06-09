package ua.com.bank.bank_card.entity;


import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private int cvc;

    private int month;

    private int year;
    private boolean block = false;
    public double getBalance() {
        return account.getBalance();
    }

    public void setBalance(double balance) {
        account.setBalance(balance);
    }
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}