package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.domain.User;
import com.samsung.repository.AuthorRepository;
import com.samsung.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User insert(String login, String password, int totalHours) {

        User user = User.builder()
                .login(login)
                .password(password)
                .totalHours(totalHours)
                .build();

        return user;
    }

    @Override
    public List<User> getAll() {

        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByLogin(String login) {

        return userRepository.findByName(login);
    }

    @Override
    public User update(int id, String login, String password, int totalHours) {

        User user = User.builder()
                .id(id)
                .login(login)
                .password(password)
                .totalHours(totalHours)
                .build();

        return user;
    }

    @Override
    public User updateUserPasswordById(int id, String password) {
        //заготовка для обновления пароля

        return userRepository.updateUserPasswordById(id, password);
    }

    @Override
    public User updateUserLoginById(int id, String login) {
        //заготовка для обновления логина

        return userRepository.updateUserLoginById(id, login);
    }

    @Override
    public void deleteById(int id) {

        userRepository.deleteById(id);
    }
}
