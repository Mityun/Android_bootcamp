package com.samsung.repository;

import com.samsung.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    User updateUserLoginById(int id, String login);

    User updateUserPasswordById(int id, String password);
}
