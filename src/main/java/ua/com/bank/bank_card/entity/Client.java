package ua.com.bank.bank_card.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 14, message = "Кількість символів повинна бути більша 2, але менша 14 символів")
    private String firstName;

    @Size(min = 2, max = 14, message = "Кількість символів повинна бути більша 2, але менша 14 символів")
    private String lastName;

    @Size(min = 2, max = 14, message = "Кількість символів повинна бути більша 2, але менша 14 символів")
    private String fatherName;

    @Email(message = "Невірний email")
    private String email;

    @Min(value = 8, message = "Мінімальна кількість символів - 8")
    private String phone;

    @Min(value = 2, message = "Мінімальна кількість символів - 2")
    private int age;
    

    @OneToOne
    @MapKey
    @MapsId
    @JoinColumn(name = "id")
    private Users users;
}