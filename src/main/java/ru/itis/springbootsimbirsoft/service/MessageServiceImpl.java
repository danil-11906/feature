package ru.itis.springbootsimbirsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;
import ru.itis.springbootsimbirsoft.domain.enums.StateActive;
import ru.itis.springbootsimbirsoft.domain.enums.StateConfirmed;
import ru.itis.springbootsimbirsoft.domain.enums.StateRole;
import ru.itis.springbootsimbirsoft.repository.AccountRepository;
import ru.itis.springbootsimbirsoft.repository.MessageRepository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Messages> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public void writeMessage(Messages form) {
        Date date = new Date();
        Messages newMessage = Messages.builder()
                .account(form.getAccount())
                .date(date)
                .room(form.getRoom())
                .text(form.getText())
                .build();

        messageRepository.save(newMessage);
    }

    @Override
    public Messages getMessage(String text) {
        return messageRepository.findFirstByText(text);
    }

    @Override
    public void updateMessage(Messages form) {
        Messages message = messageRepository.findFirstByText(form.getText());
        Messages newMessage = Messages.builder()
                .account(message.getAccount())
                .date(message.getDate())
                .room(message.getRoom())
                .text(form.getText())
                .build();

        messageRepository.save(newMessage);
    }

    @Override
    public void deleteMessage (String text){
        messageRepository.delete(messageRepository.findFirstByText(text));
    }
}
