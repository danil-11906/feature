package ru.itis.springbootsimbirsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootsimbirsoft.service.RoomService;


@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/deleteRoom")
    public String deleteRoom() {
        return "example";
    }

    @GetMapping("/updateRoom")
    public String updateRoom() {
        return "example";
    }

    @GetMapping("/readRoom")
    public String readRoom() {
        return "example";
    }

    @GetMapping("/createRoom")
    public String createRoom() {
        return "example";
    }
}
