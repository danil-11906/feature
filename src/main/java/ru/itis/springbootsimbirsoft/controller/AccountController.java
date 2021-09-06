package ru.itis.springbootsimbirsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.service.AccountService;
import ru.itis.springbootsimbirsoft.util.UserDetailsImpl;


@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signup_page";
    }

    @PostMapping("/signUp")
    public String signUp(Accounts form) {
        accountService.signUp(form);
        return "redirect:/signIn";
    }

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in_page";
    }

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        String email = userDetails.getUsername();
        model.addAttribute("email", email);
        return "profile";
    }

    @GetMapping("/")
    public String getStartPage() {
        return "sign_in_page";
    }
}
