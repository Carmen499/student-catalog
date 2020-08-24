package com.student.catalog.demo;

import javax.persistence.*;

@Entity
@Table (name = "professor_view_catalog")

public class ProfessorViewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professor_id") private int professor_id;
    @Column (name = "user_name") private String user_name;
    @Column (name = " PASSWORD") private String password;
    @Column (name = "first_name") private String first_name;
    @Column (name = "last_name") private String last_name;
    @Column (name = "student_ssn") private long student_ssn;

    public ProfessorViewEntity(){

    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
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

    public long getStudent_ssn() {
        return student_ssn;
    }

    public void setStudent_ssn(long student_ssn) {
        this.student_ssn = student_ssn;
    }

    @Override
    public String toString() {
        return "ProfessorViewEntity{" +
                "professor_id:" + professor_id +
                ", user_name:'" + user_name + '\'' +
                ", password:'" + password + '\'' +
                ", first_name:'" + first_name + '\'' +
                ", last_name:'" + last_name + '\'' +
                ", student_ssn:" + student_ssn +
                '}';
    }
}
