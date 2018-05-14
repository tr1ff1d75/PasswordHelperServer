package com.gulko.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id_user;

    @Column(name = "login", nullable = false, length = 500)
    private String login;
    @Column(name = "password", nullable = false, length = 500)
    private String password;

    public User(){}

    public long getId() {
        return id_user;
    }

    public void setId(long id) {
        this.id_user = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}