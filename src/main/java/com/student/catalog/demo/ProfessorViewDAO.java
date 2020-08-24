package com.student.catalog.demo;

import java.util.List;

public interface ProfessorViewDAO {

    //dao methods

    List<ProfessorViewEntity> findAll();
    ProfessorViewEntity findById(int id);
    void save (ProfessorViewEntity professorViewEntity);
    void deleteById(int id);
}
