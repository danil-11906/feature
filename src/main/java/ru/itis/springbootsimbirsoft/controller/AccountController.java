package ru.itis.springbootsimbirsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.springbootsimbirsoft.service.AccountService;


@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/deleteAcc")
    public String deleteAccount() {
        return "example";
    }

    @GetMapping("/updateAcc")
    public String updateAccount() {
        return "example";
    }

    @GetMapping("/readAcc")
    public String readAccount() {
        return "example";
    }

    @GetMapping("/createAcc")
    public String createAccount() {
        return "example";
    }
}
