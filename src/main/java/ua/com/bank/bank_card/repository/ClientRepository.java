package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.Client;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
