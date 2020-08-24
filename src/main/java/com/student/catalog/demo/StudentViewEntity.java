package com.student.catalog.demo;

import javax.persistence.*;

@Entity
@Table(name = "student_view_catalog")

public class StudentViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalog_id") private int catalog_id;
    @Column (name = "user_name") private String user_name;
    @Column (name = " PASSWORD") private String password;
    @Column (name = "first_name") private String first_name;
    @Column (name = "last_name") private String last_name;


    public StudentViewEntity(){

    }

    public StudentViewEntity(int catalog_id, String user_name, String password, String first_name, String last_name) {
        this.catalog_id = catalog_id;
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public int getCatalog_id() {
        return catalog_id;
    }

    public void setCatalog_id(int catalog_id) {
        this.catalog_id = catalog_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "StudentViewEntity{" +
                "catalog_id:" + catalog_id +
                ", user_name:'" + user_name + '\'' +
                ", password:'" + password + '\'' +
                ", first_name:'" + first_name + '\'' +
                ", last_name:'" + last_name + '\'' +
                '}';
    }
}
