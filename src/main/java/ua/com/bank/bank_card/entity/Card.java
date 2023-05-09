package ua.com.bank.bank_card.entity;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private int cvv;

    private int month;

    private int year;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}