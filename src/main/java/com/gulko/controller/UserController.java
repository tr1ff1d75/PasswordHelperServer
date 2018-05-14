package com.gulko.controller;

import com.gulko.entity.User;
import com.gulko.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping(value = "/ph")
public class UserController {

    @Autowired
    private UserService service;
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return service.getAll();
    }
    @RequestMapping(value = "/login/{log}/{pass}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean getUserByLogin(@PathVariable("log") String login,@PathVariable("pass") String pass) {
        return service.getByLogin(login,pass);
    }

    @RequestMapping(value = "/userData/{log}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserData(@PathVariable("log") String login) {
        return service.getByID(login);
    }
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return service.save(user);
    }

    @RequestMapping(value = "/userDelete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable("id") long id) {
        service.remove(id);
    }


    @RequestMapping(value = "/updateUser/{log}", method = RequestMethod.POST)
    @ResponseBody
    public User updateUser(@PathVariable("log") String login,@RequestBody User user) {return service.update(login,user);
    }
}
