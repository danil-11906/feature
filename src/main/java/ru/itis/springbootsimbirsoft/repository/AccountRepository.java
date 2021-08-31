package ru.itis.springbootsimbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
    Accounts findFirstById(Long id);
    Accounts findFirstByEmail(String email);
    Optional<Accounts> findByConfirmCode(String confirmCode);
}
