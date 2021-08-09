package ru.itis.springbootsimbirsoft.service;

import ru.itis.springbootsimbirsoft.domain.entity.Rooms;

import java.util.List;

public interface RoomService {
    List<Rooms> getAllRooms();

    void createRoom(Rooms form, Long author);

    void addAccount(Long accountId, Long authorId);

    void deleteAccount(String name, Long authorId);

    Rooms getRoom(Long id);

    void updateRoom(Rooms form, Long authorId);

    void deleteRoom(String name);
}
