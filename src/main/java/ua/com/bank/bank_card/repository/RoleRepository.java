package ua.com.bank.bank_card.repository;

import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.bank.bank_card.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
