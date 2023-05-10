package ua.com.bank.bank_card.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Data

@Entity
@Table(name = "roles")
public class Roles implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<Users> usersSet;

    public Roles(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}