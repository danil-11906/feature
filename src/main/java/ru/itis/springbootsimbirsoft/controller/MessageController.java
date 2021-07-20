package ru.itis.springbootsimbirsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootsimbirsoft.service.MessageService;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping("/deleteMess")
    public String deleteMessage() {
        return "example";
    }

    @GetMapping("/updateMess")
    public String updateMessage() {
        return "example";
    }

    @GetMapping("/readMess")
    public String readMessage() {
        return "example";
    }

    @GetMapping("/createMess")
    public String createMessage() {
        return "example";
    }
}
