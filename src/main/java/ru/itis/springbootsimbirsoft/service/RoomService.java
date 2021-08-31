package ru.itis.springbootsimbirsoft.service;

import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;
import ru.itis.springbootsimbirsoft.domain.enums.StateType;

import java.util.List;

public interface RoomService {
    List<Accounts> getRoomsUsers(String name);

    List<Rooms> getAllRooms(Long id);

    void createRoom(Rooms form, Long author, StateType type);

    void addAccount(Long accountId, Long authorId, String name);

    void deleteAccount(String name, Long authorId);

    Rooms getRoom(String name);

    Rooms getRoomOfId(Long id);

    void updateRoom(Rooms form, Long authorId);

    void deleteRoom(String name);

    List<Messages> getAllMessagesOfRoom(String name);
}
