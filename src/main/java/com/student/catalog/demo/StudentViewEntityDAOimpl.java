package com.student.catalog.demo;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentViewEntityDAOimpl implements StudentViewDAO {


    private EntityManager entityManager;


    @Autowired
    public StudentViewEntityDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<StudentViewEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<StudentViewEntity> myQuery = currentSession.createQuery("from StudentViewEntity ");
        List<StudentViewEntity> studentView = myQuery.getResultList();
        return studentView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public StudentViewEntity findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        StudentViewEntity studentView= currentSession.get(StudentViewEntity.class, id);
        return studentView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void save(StudentViewEntity studentViewEntity) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(studentViewEntity);


    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<StudentViewEntity> theQuery = currentSession.createQuery("delete from StudentViewEntity where id =:catalog_id");
        theQuery.setParameter("catalog_id", id);
        theQuery.executeUpdate();
    }


}
