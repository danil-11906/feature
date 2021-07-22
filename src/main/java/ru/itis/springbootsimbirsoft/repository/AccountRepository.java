package ru.itis.springbootsimbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Long> {
}
