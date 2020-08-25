package com.student.catalog.demo;

import java.util.List;

public interface LoginViewDAO {

    //dao Methods

    List<LoginViewEntity> findAll();
    LoginViewEntity findById (int id);
    void save (LoginViewEntity loginViewEntity);
    void deleteById(int id);
}
