package ua.com.bank.bank_card.entity;



import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    private String status;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL)
    private List<PaymentHistory> paymentHistoryList;

    public Payment() {
        this.paymentHistoryList = new ArrayList<>();
    }
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}