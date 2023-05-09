package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.bank.bank_card.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}
