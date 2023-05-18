package ua.com.bank.bank_card.entity;

import jakarta.persistence.*;
import lombok.*;


@Data

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String fatherName;

    private String email;

    private String phone;

    private int age;

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private Users users;
}