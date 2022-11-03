package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Instructor;

public interface IInstructorService {
    Instructor save(Instructor instructor);
    Instructor findById(Integer id);
    void deleteById(int var1);
}
