package com.student.catalog.demo.Controllers;


import com.student.catalog.demo.LoginViewDAO;
import com.student.catalog.demo.LoginViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class LoginViewController {


    @Autowired
    private final LoginViewDAO loginViewDAO;

    public LoginViewController(LoginViewDAO loginViewDAO){
        this.loginViewDAO = loginViewDAO;
    }


    // GET - Retrieve user
    //localhost:8080/users/{user_name}/retrieveAllStudents
    @GetMapping("/users/{user_name}/retrieveAllUser")
    public List<LoginViewEntity> findAll(@PathVariable String user_name) {
        return loginViewDAO.findAll();
    }

    //GET- Get Student by Id (catalog Id)
    //http://localhost:8080/users/{user_name}/retrieveStudentById/{id}
    @GetMapping("/users/{user_name}/retrieveUserById/{id}")
    public LoginViewEntity getStudent(@PathVariable String user_name, @PathVariable int id){
        LoginViewEntity theLoginViewEntity = loginViewDAO.findById(id);
        if(theLoginViewEntity == null)
            throw new RuntimeException("user id not found -" + id);
        return theLoginViewEntity;
    }

    //Post- Add a new user
    //http://localhost:8080/users/{user_name}/addStudent
    @PostMapping("/users/{user_name}/addStudent")
    public LoginViewEntity createStudent(
            @PathVariable String user_name,
            @RequestBody LoginViewEntity loginViewEntity){

        loginViewEntity.setCatalog_id(0);
        loginViewDAO.save(loginViewEntity);

        return loginViewEntity;

    }

    //PUT- Update user
    //http://localhost:8080/users/{user_name}/updateStudent/{id}
    @PutMapping("/users/{user_name}/updateStudent/{id}")
    public ResponseEntity<LoginViewEntity> updateStudent(
            @PathVariable String user_name,
            @PathVariable int id,
            @RequestBody LoginViewEntity loginViewEntity){

        loginViewDAO.save(loginViewEntity);
        return new ResponseEntity<LoginViewEntity>(loginViewEntity, HttpStatus.OK);
    }


    //Delete

    // student will not have the option to delete


}
