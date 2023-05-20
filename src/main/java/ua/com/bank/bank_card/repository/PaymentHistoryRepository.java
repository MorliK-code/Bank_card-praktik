package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.PaymentHistory;

import java.util.List;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {
    @Query("SELECT p, ph.status FROM Payment p JOIN p.paymentHistory ph")
    List<Object[]> getAllPaymentHistory();
}
