//package ru.itis.springbootsimbirsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.entity.Rooms;
import ru.itis.springbootsimbirsoft.domain.enums.StateType;
import ru.itis.springbootsimbirsoft.service.AccountService;
import ru.itis.springbootsimbirsoft.service.RoomService;
import ru.itis.springbootsimbirsoft.util.UserDetailsImpl;

import java.util.Timer;
import java.util.TimerTask;

//@Controller
//public class BotController {
//
//    @Autowired
//    private RoomService roomService;
//
//    @Autowired
//    private AccountService accountService;

//    @PostMapping("/bag")
//    public String savePerson(@RequestParam String command,
//                             @AuthenticationPrincipal UserDetailsImpl user,
//                             Model model) {
//        String[] words = command.split(" ");
//        switch (words[0]) {
//            case ("//room"):
//                switch (words[1]) {
//                    case ("create"):
//                        StateType type = StateType.PUBLIC;
//                        if (words[3].equals("-c")) {
//                            type = StateType.PRIVATE;
//                        } ;
//                        Rooms room = Rooms.builder()
//                                .name(words[2])
//                                .stateType(type)
//                                .build();
//                        roomService.createRoom(room, user.getId(), type);
//                        break;
//                    case ("remove"):
//                        roomService.deleteRoom(words[2]);
//                        break;
//                    case ("rename"):
//                        Rooms roomName = Rooms.builder()
//                                .name(words[2])
//                                .stateType(StateType.PUBLIC)
//                                .build();
//                        roomService.updateRoom(roomName, user.getId());
//                        break;
//                    case ("connect"):
//                        if (words[3].equals("-l")) {
//                            roomService.addAccount(user.getId(), user.getId());
//                        } else {
//                            roomService.addAccount(user.getId(), user.getId());
//                        }
//                        break;
//                    case ("disconnect"):
//                        if (words[3].equals("-l")) {
//                            roomService.deleteAccount(words[4], user.getId());
//                        }
//                        if (words[3].equals("-m")) {
//                            roomService.deleteAccount(words[4], user.getId());
//                            TimerTask task = new TimerTask() {
//                                public void run() {
//                                    roomService.addAccount(user.getId(), user.getId());
//                                }
//                            };
//                            Timer timer = new Timer("Timer");
//
//                            long delay = 1000;
//                            timer.schedule(task, delay);
//                        }
//                        break;
//                }
//                break;
//            case ("//user"):
//                switch (words[1]) {
//                    case ("ban"):
//                        if (words[3].equals("-l")) {
//                            roomService.deleteAccount(words[4], user.getId());
//                        }
//                        if (words[3].equals("-m")) {
//                            roomService.deleteAccount(words[4], user.getId());
//                            TimerTask task1 = new TimerTask() {
//                                public void run() {
//                                    roomService.addAccount(user.getId(), user.getId());
//                                }
//                            };
//                            Timer timer = new Timer("Timer");
//
//                            long delay = 1000;
//                            timer.schedule(task1, delay);
//                        }
//                        break;
//                    case ("rename"):
//                        Accounts accountName = Accounts.builder()
//                                .name(words[2]).build();
//                        accountService.updateUSer(accountName);
//                        break;
//                    case ("moderator"):
//                        if (words[3].equals("-n")) {
//                            accountService.changeModer(words[2], user.getId());
//                        }
//                        if (words[3].equals("-d")) {
//                            accountService.deleteModer(words[2], user.getId());
//                        }
//                        break;
//
//                }
//            case ("//help"):
//                System.out.println("Комнаты:\n" +
//                        "1. //room create {Название комнаты} - создает комнаты;\n" +
//                        "-c закрытая комната. Только (владелец, модератор и админ) может\n" +
//                        "добавлять/удалять пользователей из комнаты.\n" +
//                        "2. //room remove {Название комнаты} - удаляет комнату (владелец и админ);\n" +
//                        "3. //room rename {Название комнаты} - переименование комнаты (владелец и\n" +
//                        "админ);\n" +
//                        "4. //room connect {Название комнаты} - войти в комнату;\n" +
//                        "-l {login пользователя} - добавить пользователя в комнату\n" +
//                        "5. //room disconnect - выйти из текущей комнаты;\n" +
//                        "6. //room disconnect {Название комнаты} - выйти из заданной комнаты;\n" +
//                        "-l {login пользователя} - выгоняет пользователя из комнаты (для владельца,\n" +
//                        "модератора и админа).\n" +
//                        "-m {Количество минут} - время на которое пользователь не сможет войти (для\n" +
//                        "владельца, модератора и админа).\n" +
//                        "Пользователи:\n" +
//                        "1. //user rename {login пользователя} (владелец и админ);\n" +
//                        "2. //user ban;\n" +
//                        "-l {login пользователя} - выгоняет пользователя из всех комнат\n" +
//                        "-m {Количество минут} - время на которое пользователь не сможет войти.\n" +
//                        "3. //user moderator {login пользователя} - действия над модераторами.\n" +
//                        "-n - назначить пользователя модератором.\n" +
//                        "-d - “разжаловать” пользователя.\n" +
//                        "Боты:\n" +
//                        "1. //yBot find -k -l {название канала}||{название видео} - в ответ бот присылает\n" +
//                        "ссылку на ролик;\n" +
//                        "-v - выводит количество текущих просмотров.\n" +
//                        "-l - выводит количество лайков под видео.\n" +
//                        "2. //yBot help - список доступных команд для взаимодействия.\n" +
//                        "Другие:\n" +
//                        "1. //help - выводит список доступных команд.\n");
//                break;
//        }
//        return null;
//    }
//}
