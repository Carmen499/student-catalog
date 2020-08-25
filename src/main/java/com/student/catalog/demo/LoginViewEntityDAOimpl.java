package com.student.catalog.demo;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LoginViewEntityDAOimpl implements LoginViewDAO {


    private EntityManager entityManager;


    @Autowired
    public LoginViewEntityDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<LoginViewEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<LoginViewEntity> myQuery = currentSession.createQuery("from LoginViewEntity ");
        List<LoginViewEntity> LoginView = myQuery.getResultList();
        return LoginView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public LoginViewEntity findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        LoginViewEntity LoginView= currentSession.get(LoginViewEntity.class, id);
        return LoginView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void save(LoginViewEntity loginViewEntity) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(loginViewEntity);


    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<LoginViewEntity> theQuery = currentSession.createQuery("delete from LoginViewEntity where id =:login_id");
        theQuery.setParameter("login_id", id);
        theQuery.executeUpdate();
    }


}
