package ru.itis.springbootsimbirsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;
import ru.itis.springbootsimbirsoft.domain.enums.StateActive;
import ru.itis.springbootsimbirsoft.domain.enums.StateRole;
import ru.itis.springbootsimbirsoft.domain.enums.StateType;
import ru.itis.springbootsimbirsoft.repository.AccountRepository;
import ru.itis.springbootsimbirsoft.repository.MessageRepository;
import ru.itis.springbootsimbirsoft.repository.RoomRepository;

import java.io.IOException;
import java.util.*;

@Component
public class RoomServiceImpl implements RoomService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Accounts> getRoomsUsers(String name) {
        Rooms room = roomRepository.findFirstByName(name);
        return room.getUsers();
    }

    @Override
    public List<Rooms> getAllRooms(Long id) {
        Accounts account = accountRepository.findFirstById(id);
        return account.getRooms();
    }

    @Override
    public void createRoom(Rooms form, Long author, StateType type) {
        if (accountRepository.findFirstById(author).getStateActive() == StateActive.ACTIVE) {
            Accounts creator = accountRepository.findFirstById(author);
            List<Accounts> list = new ArrayList<Accounts>();
            list.add(creator);
            Rooms newRoom = Rooms.builder()
                    .name(form.getName())
                    .stateType(type)
                    .creator(creator)
                    .users(list)
                    .build();

            roomRepository.save(newRoom);
        }
    }

    @Override
    public void addAccount(Long accountId, Long authorId, String name) {
        Rooms roomId = roomRepository.findFirstByName(name);
        if (accountRepository.findFirstById(authorId).getStateActive() == StateActive.ACTIVE) {
            Accounts creator = accountRepository.findFirstById(authorId);
            List<Accounts> list = roomId.getUsers();
            list.add(accountRepository.findFirstById(accountId));
            Rooms newRoom = Rooms.builder()
                    .id(roomId.getId())
                    .name(roomId.getName())
                    .stateType(roomId.getStateType())
                    .creator(creator)
                    .users(list)
                    .build();
            roomRepository.save(newRoom);
        }
    }

    @Override
    public void deleteAccount(String name, Long authorId) {
        if ((accountRepository.findFirstById(authorId).getRole() == StateRole.ADMIN)||
        (accountRepository.findFirstById(authorId).getRole() == StateRole.USER)) {
            System.out.println(name);
        }
    }

    @Override
    public Rooms getRoom(String name) {
        return roomRepository.findFirstByName(name);
    }

    @Override
    public Rooms getRoomOfId(Long id) {
        return roomRepository.findFirstById(id);
    }

    @Override
    public void updateRoom(Rooms form, Long authorId) {
        if ((accountRepository.findFirstById(authorId).getRole() == StateRole.ADMIN) ||
                (accountRepository.findFirstById(authorId).getRole() == StateRole.USER)) {
            Rooms newRoom = Rooms.builder()
                    .name(form.getName())
                    .stateType(form.getStateType())
                    .build();

            roomRepository.save(newRoom);
        }
    }

    @Override
    public void deleteRoom (String name){
        roomRepository.delete(roomRepository.findFirstByName(name));
    }

    @Override
    public List<Messages> getAllMessagesOfRoom(String name) {
        Date date = new Date(1212121212121L);
        Rooms room = roomRepository.findFirstByName(name);
        Long id = room.getId();
        List<Messages> list = messageRepository.findAllByRoom_Id(id);
        if(list.size()==0) {
            System.out.println("*");
            System.out.println(date);
            System.out.println("*");
            Messages newMes = Messages.builder()
                    .id(id)
                    .date(date)
                    .account(Accounts.builder().name("no message").build())
                    .text("you can write message")
                    .build();
            list.add(newMes);
        }
        return list;

    }
}
