package com.student.catalog.demo;

import java.util.List;

public interface StudentViewDAO {

    //dao Methods

    List<StudentViewEntity> findAll();
    StudentViewEntity findById (int id);
    void save (StudentViewEntity studentViewEntity);
    void deleteById(int id);
}
