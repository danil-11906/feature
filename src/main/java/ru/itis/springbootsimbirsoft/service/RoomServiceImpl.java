package ru.itis.springbootsimbirsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;
import ru.itis.springbootsimbirsoft.domain.enums.StateActive;
import ru.itis.springbootsimbirsoft.domain.enums.StateRole;
import ru.itis.springbootsimbirsoft.repository.AccountRepository;
import ru.itis.springbootsimbirsoft.repository.MessageRepository;
import ru.itis.springbootsimbirsoft.repository.RoomRepository;

import java.util.Date;
import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Rooms> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void createRoom(Rooms form, Long author) {
        if (accountRepository.findFirstById(author).getStateActive() == StateActive.ACTIVE) {
            Rooms newRoom = Rooms.builder()
                    .name(form.getName())
                    .stateType(form.getStateType())
                    .build();

            roomRepository.save(newRoom);
        }
    }

    @Override
    public void addAccount(Long accountId, Long authorId) {
        if (accountRepository.findFirstById(authorId).getStateActive() == StateActive.ACTIVE) {
            System.out.println(accountId);
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
    public Rooms getRoom(Long id) {
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
}
