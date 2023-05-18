package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.bank.bank_card.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findAllByUsername(String name);
    Users findByUsername(String name);
}