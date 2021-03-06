package com.student.catalog.demo;

import javax.persistence.*;

@Entity
@Table (name = "catalog_view")

public class CatalogViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") private int id;
    @Column (name = "student_first_name") private String student_first_name;
    @Column (name = "student_last_name") private String student_last_name;
    @Column (name = "student_ssn") private long student_ssn;

    public CatalogViewEntity(){

    }

    public CatalogViewEntity(int id, String student_first_name, String student_last_name, long student_ssn) {
        this.id = id;
        this.student_first_name = student_first_name;
        this.student_last_name = student_last_name;
        this.student_ssn = student_ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_first_name() {
        return student_first_name;
    }

    public void setStudent_first_name(String student_first_name) {
        this.student_first_name = student_first_name;
    }

    public String getStudent_last_name() {
        return student_last_name;
    }

    public void setStudent_last_name(String student_last_name) {
        this.student_last_name = student_last_name;
    }

    public long getStudent_ssn() {
        return student_ssn;
    }

    public void setStudent_ssn(long student_ssn) {
        this.student_ssn = student_ssn;
    }

    @Override
    public String toString() {
        return "CatalogViewEntity{" +
                "id:" + id +
                ", student_first_name:'" + student_first_name + '\'' +
                ", student_last_name:'" + student_last_name + '\'' +
                ", student_ssn:" + student_ssn +
                '}';
    }
}
