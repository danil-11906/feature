package ru.itis.springbootsimbirsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;
import ru.itis.springbootsimbirsoft.service.AccountService;
import ru.itis.springbootsimbirsoft.service.MessageService;
import ru.itis.springbootsimbirsoft.service.RoomService;
import ru.itis.springbootsimbirsoft.util.UserDetailsImpl;

@Controller
public class MessageController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private MessageService messageService;

    @PostMapping("/writeMessage/{roomId}")
    public String addMessage(@PathVariable("roomId") Long id, Messages form,
                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        messageService.writeMessage(form, userDetails.getId(), id);
        Rooms room = roomService.getRoomOfId(id);
        return "redirect:/sms/"+room.getName();
    }

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
