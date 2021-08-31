package ru.itis.springbootsimbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messages, Long> {
    Messages findFirstByText(String text);
    List<Messages> findAllByRoom_Id(Long id);
}
