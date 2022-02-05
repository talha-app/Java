package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.InstructorDetails;

public interface IInstructorDetailsService {
    InstructorDetails findById(int id);
    void deleteById(int var1);
}
