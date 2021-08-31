package ru.itis.springbootsimbirsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.springbootsimbirsoft.domain.entity.Accounts;
import ru.itis.springbootsimbirsoft.domain.enums.StateActive;
import ru.itis.springbootsimbirsoft.domain.enums.StateConfirmed;
import ru.itis.springbootsimbirsoft.domain.enums.StateRole;
import ru.itis.springbootsimbirsoft.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class AccountServiceImpl implements AccountService {

    @Autowired
    private SmsService smsService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Accounts> getAllUser() {
        return accountRepository.findAll();
    }

    @Override
    public List<Accounts> getAllUsers(Long id) {
        List<Accounts> accountsList = accountRepository.findAll();
        for (int i = 0; i < accountsList.size(); i++) {
            if (accountsList.get(i).getId().equals(id)) {
                accountsList.remove(i);
            }
        }
        return accountsList;
    }

    @Override
    public void signUp(Accounts form) {
        Accounts newUser = Accounts.builder()
                .email(form.getEmail())
                .name(form.getName())
                .surname(form.getSurname())
                .password(passwordEncoder.encode(form.getPassword()))
                .phone(form.getPhone())
                .role(StateRole.USER)
                .stateActive(StateActive.ACTIVE)
                .stateConfirmed(StateConfirmed.NOT_CONFIRMED)
                .confirmCode(UUID.randomUUID().toString())
                .build();

        accountRepository.save(newUser);
        smsService.sendSms(form.getPhone(), "Вы зарегестированы");
    }

    @Override
    public Accounts getUser(Long id) {
        return accountRepository.findFirstById(id);
    }

    @Override
    public void updateUSer(Accounts form) {
        Accounts account = accountRepository.findFirstById(form.getId());
        if (account.getEmail().equals(form.getEmail())){
            account.setEmail(form.getEmail());
        }
        if (account.getName().equals(form.getName())){
            account.setName(form.getName());
        }
        if (account.getSurname().equals(form.getSurname())){
            account.setSurname(form.getSurname());
        }
        if (account.getPassword().equals(form.getPassword())){
            account.setPassword(form.getPassword());
        }
        if (account.getPhone().equals(form.getPhone())){
            account.setPhone(form.getPhone());
        }
        Accounts newUser = Accounts.builder()
                .email(account.getEmail())
                .name(account.getName())
                .surname(account.getSurname())
                .password(passwordEncoder.encode(account.getPassword()))
                .phone(account.getPhone())
                .role(account.getRole())
                .stateActive(account.getStateActive())
                .stateConfirmed(account.getStateConfirmed())
                .confirmCode(account.getConfirmCode())
                .build();

        accountRepository.save(newUser);
    }

    @Override
    public void deleteUser (Long id){
        accountRepository.delete(accountRepository.findFirstById(id));
    }

    @Override
    public void blockUser(Long id, Long adminId){
        if ((accountRepository.findFirstById(adminId).getRole()==StateRole.ADMIN)||
                (accountRepository.findFirstById(adminId).getRole()==StateRole.MODERATOR)) {
            Accounts form = accountRepository.findFirstById(id);
            Accounts newUser = Accounts.builder()
                    .email(form.getEmail())
                    .name(form.getName())
                    .surname(form.getSurname())
                    .password(form.getPassword())
                    .phone(form.getPhone())
                    .role(form.getRole())
                    .stateActive(StateActive.BANNED)
                    .stateConfirmed(form.getStateConfirmed())
                    .confirmCode(form.getConfirmCode())
                    .build();

            accountRepository.save(newUser);
        }
    }

    @Override
    public void unBlockUser(Long id, Long adminId) {
        if ((accountRepository.findFirstById(adminId).getRole()==StateRole.ADMIN)||
                (accountRepository.findFirstById(adminId).getRole()==StateRole.MODERATOR)) {
            Accounts form = accountRepository.findFirstById(id);
            Accounts newUser = Accounts.builder()
                    .email(form.getEmail())
                    .name(form.getName())
                    .surname(form.getSurname())
                    .password(form.getPassword())
                    .phone(form.getPhone())
                    .role(form.getRole())
                    .stateActive(StateActive.ACTIVE)
                    .stateConfirmed(form.getStateConfirmed())
                    .confirmCode(form.getConfirmCode())
                    .build();

            accountRepository.save(newUser);
        }
    }

    @Override
    public void changeModer(String login, Long adminId) {
        if (accountRepository.findFirstById(adminId).getRole()==StateRole.ADMIN) {
            Accounts form = accountRepository.findFirstByEmail(login);
            Accounts newUser = Accounts.builder()
                    .email(form.getEmail())
                    .name(form.getName())
                    .surname(form.getSurname())
                    .password(form.getPassword())
                    .phone(form.getPhone())
                    .role(StateRole.MODERATOR)
                    .stateActive(form.getStateActive())
                    .stateConfirmed(form.getStateConfirmed())
                    .confirmCode(form.getConfirmCode())
                    .build();

            accountRepository.save(newUser);
        }
    }

    @Override
    public void deleteModer(String name, Long adminId) {
        if (accountRepository.findFirstById(adminId).getRole()==StateRole.ADMIN) {

            Accounts form = accountRepository.findFirstByEmail(name);
            Accounts newUser = Accounts.builder()
                    .email(form.getEmail())
                    .name(form.getName())
                    .surname(form.getSurname())
                    .password(form.getPassword())
                    .phone(form.getPhone())
                    .role(StateRole.USER)
                    .stateActive(form.getStateActive())
                    .stateConfirmed(form.getStateConfirmed())
                    .confirmCode(form.getConfirmCode())
                    .build();

            accountRepository.save(newUser);
        }
    }

}
