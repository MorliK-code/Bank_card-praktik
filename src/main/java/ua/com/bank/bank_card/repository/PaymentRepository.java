package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
