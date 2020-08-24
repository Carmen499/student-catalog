package com.student.catalog.demo;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProfessorViewEntityDAOimpl implements ProfessorViewDAO {

    private EntityManager entityManager;


    @Autowired
    public ProfessorViewEntityDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<ProfessorViewEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ProfessorViewEntity> myQuery = currentSession.createQuery("from ProfessorViewEntity ");
        List<ProfessorViewEntity> professorView = myQuery.getResultList();
        return professorView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public ProfessorViewEntity findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ProfessorViewEntity professorView= currentSession.get(ProfessorViewEntity.class, id);
        return professorView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void save(ProfessorViewEntity professorViewEntity) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(professorViewEntity);


    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ProfessorViewEntity> theQuery = currentSession.createQuery("delete from ProfessorViewEntity where id =:professor_id");
        theQuery.setParameter("professor_id", id);
        theQuery.executeUpdate();
    }


}
