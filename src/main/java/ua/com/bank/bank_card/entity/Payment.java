package ua.com.bank.bank_card.entity;

import jakarta.persistence.*;
import lombok.*;

@Data

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String senderNumber;
    private String recipientNumber;
    private double amount;

    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
}