package com.student.catalog.demo.Controllers;

import com.student.catalog.demo.CatalogViewDAO;
import com.student.catalog.demo.CatalogViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
public class CatalogViewController {


    @Autowired
    private final CatalogViewDAO catalogViewDAO;

    public CatalogViewController(CatalogViewDAO catalogViewDAO){
        this.catalogViewDAO = catalogViewDAO;
    }


    // GET - Retrieve students
    //http://localhost:8080/users/{user_name}/catalog/retrieveAllStudents
    @GetMapping("/users/{user_name}/catalog/retrieveAllStudents")
    public List<CatalogViewEntity> findAllStudents(@PathVariable String user_name) {
        return catalogViewDAO.findAll();
    }

    //GET- Get student by Id
    //http://localhost:8080/users/{user_name}/catalog/retrieveStudentById/{id}
    @GetMapping("/users/{user_name}/catalog/retrieveStudentById/{id}")
    public CatalogViewEntity getStudent( @PathVariable String user_name,@PathVariable int id){
        CatalogViewEntity theCatalogViewEntity = catalogViewDAO.findById(id);
        if(theCatalogViewEntity == null)
            throw new RuntimeException("Student catalog id not found -" + id);
        return theCatalogViewEntity;
    }

    //Post- Add a new student
    //http://localhost:8080/users/{user_name}/catalog/addStudent
    @PostMapping("/users/{user_name}/catalog/addStudent")
    public CatalogViewEntity createStudent(
            @RequestBody CatalogViewEntity catalogViewEntity,
            @PathVariable String user_name){

        catalogViewEntity.setCatalog_id(0);
        catalogViewDAO.save(catalogViewEntity);

        return catalogViewEntity;

    }


    //PUT- Update student
    //http://localhost:8080/users/{user_name}/catalog/updateStudent/{id}
    @PutMapping("/users/{user_name}/catalog/updateStudent/{id}")
    public ResponseEntity<CatalogViewEntity> updateStudent(
            @PathVariable String user_name,
            @PathVariable int id,
            @RequestBody CatalogViewEntity catalogViewEntity){

        catalogViewDAO.save(catalogViewEntity);
        return new ResponseEntity<CatalogViewEntity>(catalogViewEntity, HttpStatus.OK);
    }

    //DELETE student
    //http://localhost:8080/users/{user_name}/catalog/deleteStudent/{id}
    @DeleteMapping("/users/{user_name}/catalog/deleteStudent/{id}")
    public String deleteStudent(@PathVariable String user_name, @PathVariable int id) {

        //Creating a tempStudent to check to see if a student exists
        CatalogViewEntity tempCatalogViewEntity = catalogViewDAO.findById(id);

        //This will throw an exception if the student is null
        if(tempCatalogViewEntity == null) {
            throw new RuntimeException("Student not found : " + id);
        }

        //This will execute the deleteByID method in the ProfessorViewEntityDaoImpl.
        catalogViewDAO.deleteById(id);
        return "Student deleted at id : " + id;
    }


}
