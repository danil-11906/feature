package ru.itis.springbootsimbirsoft.service;

import ru.itis.springbootsimbirsoft.domain.entity.Accounts;

import java.util.List;

public interface AccountService {

    List<Accounts> getAllUsers();

    void signUp(Accounts form);

    Accounts getUser(Long id);

    void updateUSer(Accounts form);

    void deleteUser(Long id);
}
