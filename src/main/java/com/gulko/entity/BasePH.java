package com.gulko.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "base_table")
public class BasePH {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;
    public String getSite() {
        return site;
    }
    public void setSite(String site) {
        this.site = site;
    }
    @Column(name = "site", nullable = true,length = 500)
    private String site;

    public String getSiteLogin() {
        return siteLogin;
    }
    public void setSiteLogin(String siteLogin) {
        this.siteLogin = siteLogin;
    }
    @Column(name = "site_login", nullable = true,length = 500)
    private String siteLogin;

    public String getSitePass() {
        return sitePass;
    }
    public void setSitePass(String sitePass) {
        this.sitePass = sitePass;
    }
    @Column(name = "site_password", nullable = true,length = 500)
    private String sitePass;

    public String getLogin() {return login;}
    public void setLogin(String login) {
        this.login = login;
    }
    @Column(name = "login_user",nullable = false)
    private String login;

    public BasePH(){}

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }



}
