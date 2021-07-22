package ru.itis.springbootsimbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;

public interface MessageRepository extends JpaRepository<Messages, Long> {
}
