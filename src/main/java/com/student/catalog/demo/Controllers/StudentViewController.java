package com.student.catalog.demo.Controllers;


import com.student.catalog.demo.StudentViewDAO;
import com.student.catalog.demo.StudentViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class StudentViewController {


    @Autowired
    private final StudentViewDAO studentViewDAO;

    public StudentViewController(StudentViewDAO studentViewDAO){
        this.studentViewDAO = studentViewDAO;
    }


    // GET - Retrieve  Students
    //localhost:8080/users/{user_name}/retrieveAllStudents
    @GetMapping("/users/{user_name}/retrieveAllStudents")
    public List<StudentViewEntity> findAll(@PathVariable String user_name) {
        return studentViewDAO.findAll();
    }

    //GET- Get Student by Id (catalog Id)
    //http://localhost:8080/users/{user_name}/retrieveStudentById/{id}
    @GetMapping("/users/{user_name}/retrieveStudentById/{id}")
    public StudentViewEntity getStudent(@PathVariable String user_name, @PathVariable int id){
        StudentViewEntity theStudentViewEntity = studentViewDAO.findById(id);
        if(theStudentViewEntity == null)
            throw new RuntimeException("Student id not found -" + id);
        return theStudentViewEntity;
    }

    //Post- Add a new student
    //http://localhost:8080/users/{user_name}/addStudent
    // On the front end by the add button you can put.. are you new student? you can add your name to the roster"
    // have an alert icon "You are a new student!, add your name"... we have to do this because catalog id is not a fk  of professor's catalog
    // so if the professor adds a new student ideally it will not populate on the student view's side, student will have to add his name manually with a generated catalog id.
    @PostMapping("/users/{user_name}/addStudent")
    public StudentViewEntity createStudent(
            @PathVariable String user_name,
            @RequestBody StudentViewEntity studentViewEntity ){

        studentViewEntity.setCatalog_id(0);
        studentViewDAO.save(studentViewEntity);

        return studentViewEntity;

    }

    //PUT- Update student
    //http://localhost:8080/users/{user_name}/updateStudent/{id}
    @PutMapping("/users/{user_name}/updateStudent/{id}")  //id or catalog id...if doesnt work, try catalog id
    public ResponseEntity<StudentViewEntity> updateStudent(
            @PathVariable String user_name,
            @PathVariable int id,
            @RequestBody StudentViewEntity studentViewEntity){

        studentViewDAO.save(studentViewEntity);
        return new ResponseEntity<StudentViewEntity>(studentViewEntity, HttpStatus.OK);
    }


    //Delete

    // student will not have the option to delete


}
