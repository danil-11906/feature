package ru.itis.springbootsimbirsoft.service;

import ru.itis.springbootsimbirsoft.domain.entity.Messages;

import java.util.List;

public interface MessageService {
    List<Messages> getAllMessages();

    void writeMessage(Messages form, Long author);

    Messages getMessage(String text);

    void updateMessage(Messages form);

    void deleteMessage(String text, Long adminId);
}
