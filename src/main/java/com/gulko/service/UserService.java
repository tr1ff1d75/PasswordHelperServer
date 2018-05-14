package com.gulko.service;

import com.gulko.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getByID(String log);
    Boolean getByLogin(String log, String pass);
    User save(User user);
    void remove(long id);
    User update(String login,User user);
}
