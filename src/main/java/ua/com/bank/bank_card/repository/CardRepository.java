package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.Card;


@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
    Card findByNumber(String number);
    boolean existsByNumber(String number);
    void deleteById(Long id);
}
