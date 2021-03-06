package ru.itis.springbootsimbirsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Messages;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;
import ru.itis.springbootsimbirsoft.domain.enums.StateActive;
import ru.itis.springbootsimbirsoft.domain.enums.StateType;
import ru.itis.springbootsimbirsoft.repository.RoomRepository;
import ru.itis.springbootsimbirsoft.service.AccountService;
import ru.itis.springbootsimbirsoft.service.MessageService;
import ru.itis.springbootsimbirsoft.service.RoomService;
import ru.itis.springbootsimbirsoft.util.UserDetailsImpl;

import java.util.List;


@Controller
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageService messageService;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/list")
    public Object getUsersPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("roomsList", roomService.getAllRooms(userDetails.getId()));
        return "list";
    }

    @GetMapping("/createRoom")
    public String createRoom(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        model.addAttribute("usersList", accountService.getAllUsers(userDetails.getId()));
        return "create_room_page";
    }

    @PostMapping("/createRoom")
    public String creatingRoom(Rooms room,
                               @AuthenticationPrincipal UserDetailsImpl userDetails,
                               @RequestParam("selected") String selected,
                               @RequestParam("changed") String changed) {
        StateType type = StateType.PUBLIC;
        if (selected.equals("PRIVATE")){
            type = StateType.PRIVATE;
            String[] checked = changed.split(",");
            if (checked.length==1) {
                roomService.createRoom(room, userDetails.getId(), type);
                String name = room.getName();
                List<Accounts> accountsList = accountService.getAllUser();
                for (Accounts accounts : accountsList) {
                    for (String string : checked) {
                        if (string.equals(accounts.getName())) {
                            roomService.addAccount(accounts.getId(), userDetails.getId(), name);
                        }
                    }
                }
            }
            else {
                return "redirect:/createRoom";
            }

        }
        else {
            roomService.createRoom(room, userDetails.getId(), type);
            String name = room.getName();
            String[] checked = changed.split(",");
            List<Accounts> accountsList = accountService.getAllUser();
            for (Accounts accounts : accountsList) {
                for (String string : checked) {
                    if (string.equals(accounts.getName())) {
                        roomService.addAccount(accounts.getId(), userDetails.getId(), name);
                    }
                }
            }
        }

        return "redirect:/list";
    }

    @GetMapping("/sms/{room}")
    public String getMessage(@PathVariable("room") String name, Model model) {
        model.addAttribute("roomInfo", roomService.getRoom(name));
        model.addAttribute("usersList", roomService.getRoomsUsers(name));
        model.addAttribute("messages", roomService.getAllMessagesOfRoom(name));
        return "room_page";
    }

    @GetMapping("/message/{room}")
    @ResponseBody
    public ResponseEntity<List<Messages>> getAllMessage(@PathVariable("room") String name){
        System.out.println("************");
        return ResponseEntity.ok(roomService.getAllMessagesOfRoom(name));
    }

    @GetMapping("/addUser/{room}")
    public String addUser(@PathVariable("room") Long id,
                          Model model) {
        model.addAttribute("usersList", accountService.getUsersForPut(id));
        model.addAttribute("room", roomRepository.findFirstById(id));
        return "add_users_page";
    }

    @PostMapping("/addUser/{room}")
    public String addUserForRooms(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                  @RequestParam("changed") String changed,
                                  @PathVariable("room") Long id) {
        String name = roomRepository.findFirstById(id).getName();
        String[] checked = changed.split(",");
        List<Accounts> accountsList = accountService.getAllUser();
        for (Accounts accounts : accountsList) {
            for (String string : checked) {
                if (string.equals(accounts.getName())) {
                    roomService.addAccount(accounts.getId(), userDetails.getId(), name);
                }
            }
        }
        return "redirect:/sms/" + name;
    }

    @PostMapping("/deleteUser/{room}")
    public String deleteUserFromRooms(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                  @RequestParam("deleted") String changed,
                                  @PathVariable("room") Long id) {
        String name = roomRepository.findFirstById(id).getName();
        String[] checked = changed.split(",");
        List<Accounts> accountsList = accountService.getAllUser();
        for (Accounts accounts : accountsList) {
            for (String string : checked) {
                if (string.equals(accounts.getName())) {
                    roomService.deleteAccount(accounts.getId(), userDetails.getId(), id);
                }
            }
        }
        return "redirect:/sms/" + name;
    }

    @GetMapping("/renameRoom/{room}")
    public String getRenamePage(@PathVariable("room") Long id,
                                Model model) {
        model.addAttribute("roomsList", roomRepository.findFirstById(id));
        return "rename_room_page";
    }

    @PostMapping("/renameRoom/{room}")
    public String renameRoomPost(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                  @PathVariable("room") Long id,
                                 Rooms room) {
        roomService.updateRoom(room, userDetails.getId(), id);
        String name = roomRepository.findFirstById(id).getName();
        return "redirect:/sms/" + name;
    }

    @PostMapping("/deleteRoom/{room}")
    public String deleteRoomPost(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                 @PathVariable("room") Long id) {
        roomService.deleteRoom(roomRepository.findFirstById(id).getName(), userDetails.getId());
        return "redirect:/list";
    }
}