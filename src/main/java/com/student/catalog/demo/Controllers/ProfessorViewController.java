package com.student.catalog.demo.Controllers;

import com.student.catalog.demo.ProfessorViewDAO;
import com.student.catalog.demo.ProfessorViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProfessorViewController {


    @Autowired
    private final ProfessorViewDAO professorViewDAO;

    public ProfessorViewController(ProfessorViewDAO professorViewDAO){
        this.professorViewDAO = professorViewDAO;
    }


    // GET - Retrieve  Students
    //localhost:8080/users/professor/{user_name}/retrieveAllStudents
    @GetMapping("/users/professor/{user_name}/retrieveAllStudents")
    public List<ProfessorViewEntity> findAll(@PathVariable String user_name) {
        return professorViewDAO.findAll();
    }

    //GET- Get Student by Id (catalog Id)
    //http://localhost:8080/users/professor/{user_name}/retrieveStudentById/{id}
    @GetMapping("/users/professor/{user_name}/retrieveStudentById/{id}")
    public ProfessorViewEntity getStudent(@PathVariable String user_name, @PathVariable int id){
        ProfessorViewEntity theProfessorViewEntity = professorViewDAO.findById(id);
        if(theProfessorViewEntity == null)
            throw new RuntimeException("Student id not found -" + id);
        return theProfessorViewEntity;
    }

    //Post- Add a new student
    //http://localhost:8080/users/{user_name}/addStudent

    @PostMapping("/users/professor/{user_name}/addStudent")
    public ProfessorViewEntity createStudent(
            @PathVariable String user_name,
            @RequestBody ProfessorViewEntity professorViewEntity ){

        professorViewEntity.setProfessor_id(0);      /////*******this should change to . set catalog id once fk added
        professorViewDAO.save(professorViewEntity);

        return professorViewEntity;

    }

    //PUT- Update student
    //http://localhost:8080/users/{user_name}/updateStudent/{id}
    @PutMapping("/users/professor/{user_name}/updateStudent/{id}")  //id or catalog id...if doesnt work, try catalog id
    public ResponseEntity<ProfessorViewEntity> updateStudent(
            @PathVariable String user_name,
            @PathVariable int id,
            @RequestBody ProfessorViewEntity professorViewEntity){

        professorViewDAO.save(professorViewEntity);
        return new ResponseEntity<ProfessorViewEntity>(professorViewEntity, HttpStatus.OK);
    }

    //DELETE .
    //http://localhost:8080/users/professor/{user_name}/deleteStudent/{id}
    @DeleteMapping("/users/professor/{user_name}/deleteStudent/{id}")
    public String deleteFlashCards(@PathVariable String user_name, @PathVariable int id) {

        //Creating a tempStudent to check to see if a student exists
        ProfessorViewEntity tempProfessorView = professorViewDAO.findById(id);

        //This will throw an exception if the student is null
        if(tempProfessorView == null) {
            throw new RuntimeException("Student not found : " + id);
        }

        //This will execute the deleteByID method in the ProfessorViewEntityDaoImpl.
        professorViewDAO.deleteById(id);
        return "Student deleted at id : " + id;
    }


}
