package ua.com.bank.bank_card.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "payment_history")
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private String status;

}
