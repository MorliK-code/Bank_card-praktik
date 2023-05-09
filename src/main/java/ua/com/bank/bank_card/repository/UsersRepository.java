package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.bank.bank_card.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
