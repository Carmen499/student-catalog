package com.student.catalog.demo;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CatalogViewEntityDAOimpl implements CatalogViewDAO {

    private EntityManager entityManager;


    @Autowired
    public CatalogViewEntityDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;

    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<CatalogViewEntity> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<CatalogViewEntity> myQuery = currentSession.createQuery("from CatalogViewEntity ");
        List<CatalogViewEntity> catalogView = myQuery.getResultList();
        return catalogView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public CatalogViewEntity findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        CatalogViewEntity catalogView= currentSession.get(CatalogViewEntity.class, id);
        return catalogView;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void save(CatalogViewEntity catalogViewEntity) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(catalogViewEntity);


    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<CatalogViewEntity> theQuery = currentSession.createQuery("delete from CatalogViewEntity where id =:id");
        theQuery.setParameter("id", id);
        theQuery.executeUpdate();
    }


}
