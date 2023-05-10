package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.Users;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    // select * from `user` where username = ?
    List<Users> findAllByUsername(String name);

    Users findByUsername(String name);
}
