package com.sopregistration.databasediscoveryclient.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sectioncheck")
public class SectionChecked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Student student;
    private Section section;
    private Timestamp dateTime;
    private Boolean status;

    // constructor


    public SectionChecked() {
    }

    public SectionChecked(Student student, Section section, Timestamp dateTime, Boolean status) {
        this.student = student;
        this.section = section;
        this.dateTime = dateTime;
        this.status = status;
    }
    // getter setter


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
