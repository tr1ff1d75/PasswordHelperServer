package com.gulko.service;

import com.gulko.entity.User;
import com.gulko.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Transactional(readOnly=true)
    public List<User> getAll() {
        return repository.findAll();
    }

    public User getByID(String log) {
        List<User> ur=repository.findAll();
        for (User item: ur) {
            if(item.getLogin().equals(log)) { return item;}
        }
        return null;
    }
    public Boolean getByLogin(String log,String pass) {
        List<User> ur=repository.findAll();
        for (User item: ur) {
            if(item.getLogin().equals(log) && item.getPassword().equals(pass)) return true;
        }
        return false;
    }


    public User save(User user) {
        return repository.saveAndFlush(user);
    }

    public void remove(long id) {
        repository.delete(id);
    }

    public User update(String login,User user){
        List<User> ur=repository.findAll();
        long id_us;
        for (User item: ur) {
            if(item.getLogin().equals(login)) { id_us=item.getId(); repository.delete(item.getId()); user.setId(id_us); }
        }
        return repository.saveAndFlush(user);
    }
}