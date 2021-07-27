package ru.itis.springbootsimbirsoft.service;

import ru.itis.springbootsimbirsoft.domain.entity.Rooms;

import java.util.List;

public interface RoomService {
    List<Rooms> getAllRooms();

    void createRoom(Rooms form);

    Rooms getRoom(Long id);

    void updateRoom(Rooms form);

    void deleteRoom(Long id);
}
