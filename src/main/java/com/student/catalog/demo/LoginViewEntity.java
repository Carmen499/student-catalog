package com.student.catalog.demo;

import javax.persistence.*;

@Entity
@Table(name = "catalog_login")

public class LoginViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id") private int catalog_id;
    @Column(name = "user_name") private String user_name;
    @Column(name = " PASSWORD") private String password;


    public LoginViewEntity() {

    }

    public LoginViewEntity(int catalog_id, String user_name, String password) {
        this.catalog_id = catalog_id;
        this.user_name = user_name;
        this.password = password;
    }

    public int getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginViewEntity{" +
                "catalog_id:" + catalog_id +
                ", user_name:'" + user_name + '\'' +
                ", password:'" + password + '\'' +
                '}';
    }
}

