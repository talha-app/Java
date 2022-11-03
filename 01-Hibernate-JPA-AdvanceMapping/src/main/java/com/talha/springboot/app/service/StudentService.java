package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Student;
import com.talha.springboot.app.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository m_repository;

    @Override
    public Student findById(int id) {
        return m_repository.findById(id).get();
    }

    @Override
    public List<Integer> findCoursesById(Integer id) {
        return m_repository.findCoursesById(id);
    }

    @Override
    public Student save(Student student) {
        return m_repository.save(student);
    }
}
