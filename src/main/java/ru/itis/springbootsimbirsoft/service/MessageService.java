package ru.itis.springbootsimbirsoft.service;

import ru.itis.springbootsimbirsoft.domain.entity.Messages;

import java.util.List;

public interface MessageService {
    List<Messages> getAllMessages();

    void writeMessage(Messages form);

    Messages getMessage(String text);

    void updateMessage(Messages form);

    void deleteMessage(String text);
}
