package ru.itis.springbootsimbirsoft.service;

public interface SmsService {
    void sendSms(String phone, String text);
}