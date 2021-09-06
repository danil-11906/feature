package ru.itis.springbootsimbirsoft.service;

import ru.itis.springbootsimbirsoft.domain.entity.Accounts;

import java.util.List;

public interface AccountService {

    List<Accounts> getAllUsers(Long id);

    List<Accounts> getUsersForPut(Long id);

    List<Accounts> getAllUser();

    void signUp(Accounts form);

    Accounts getUser(Long id);

    void updateUSer(Accounts form);

    void deleteUser(Long id);

    void blockUser(Long id, Long adminId);

    void unBlockUser(Long id, Long adminId);

    void changeModer(String login, Long adminId);

    void deleteModer(String name, Long adminId);
}
