package com.teacher.teacher.model.array;
import com.teacher.teacher.model.Student;

import java.util.List;

public class StudentList {
    private List<Student> studentList;

    public StudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentList(){

    }

    // getter setter

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

