package ru.itis.springbootsimbirsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;
import ru.itis.springbootsimbirsoft.repository.MessageRepository;
import ru.itis.springbootsimbirsoft.repository.RoomRepository;

import java.util.Date;
import java.util.List;

@Component
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Rooms> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public void createRoom(Rooms form) {
        Rooms newRoom = Rooms.builder()
                .name(form.getName())
                .stateType(form.getStateType())
                .build();

        roomRepository.save(newRoom);
    }

    @Override
    public Rooms getRoom(Long id) {
        return roomRepository.findFirstById(id);
    }

    @Override
    public void updateRoom(Rooms form) {
        Rooms newRoom = Rooms.builder()
                .name(form.getName())
                .stateType(form.getStateType())
                .build();

        roomRepository.save(newRoom);
    }

    @Override
    public void deleteRoom (Long id){
        roomRepository.delete(roomRepository.findFirstById(id));
    }
}
