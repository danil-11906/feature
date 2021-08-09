package ru.itis.springbootsimbirsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;

public interface RoomRepository extends JpaRepository<Rooms, Long> {
    Rooms findFirstByName(String name);
    Rooms findFirstById(Long id);
}
