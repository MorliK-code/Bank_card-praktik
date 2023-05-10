package ua.com.bank.bank_card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.Roles;
@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
}
