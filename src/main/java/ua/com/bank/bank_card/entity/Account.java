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

    @OneToMany(mappedBy = "account")
    private List<Card> card;
}
