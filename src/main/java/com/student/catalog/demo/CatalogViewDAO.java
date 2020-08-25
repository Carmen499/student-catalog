package com.student.catalog.demo;

import java.util.List;

public interface CatalogViewDAO {

    //dao methods

    List<CatalogViewEntity> findAll();
    CatalogViewEntity findById(int id);
    void save (CatalogViewEntity catalogViewEntity);
    void deleteById(int id);
}
