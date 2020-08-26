package com.student.catalog.demo.Controllers;


import com.student.catalog.demo.LoginViewDAO;
import com.student.catalog.demo.LoginViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
    //http://localhost:8080/users/{user_name}/retrieveUserById/{id}
    @GetMapping("/users/{user_name}/retrieveUserById/{catalog_id}")
    public LoginViewEntity getStudent(@PathVariable String user_name, @PathVariable int catalog_id){
        LoginViewEntity theLoginViewEntity = loginViewDAO.findById(catalog_id);
        if(theLoginViewEntity == null)
            throw new RuntimeException("user id not found -" + catalog_id);
        return theLoginViewEntity;
    }



//


    //Delete

    // student will not have the option to delete


}
