package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Modifying
    @Query("DELETE FROM Payment p WHERE p.card.id = :cardId")
    void deleteByCardId(@Param("cardId") Long cardId);
    Payment save(Payment payment);
}
