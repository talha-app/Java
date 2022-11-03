package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Student;

import java.util.List;

public interface IStudentService {
    Student findById(int id);
    List<Integer> findCoursesById(Integer id);
    Student save(Student student);
}
