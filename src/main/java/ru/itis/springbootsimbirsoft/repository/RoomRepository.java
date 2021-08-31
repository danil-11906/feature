package ru.itis.springbootsimbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;

import java.util.List;

public interface RoomRepository extends JpaRepository<Rooms, Long> {
    Rooms findFirstByName(String name);
    Rooms findFirstById(Long id);
}
