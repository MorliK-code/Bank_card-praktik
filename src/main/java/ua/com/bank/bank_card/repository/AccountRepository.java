package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.bank.bank_card.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
