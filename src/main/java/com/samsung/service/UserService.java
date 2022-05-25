package com.samsung.service;

import com.samsung.domain.User;

import java.util.List;

public interface UserService {

    User insert(String login, String password, int totalHours);

    List<User> getAll();

    User getById(int id);

    User getByLogin(String login);

    User update(int id, String login, String password, int totalHours);

    void deleteById(int id);
}
