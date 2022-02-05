package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.InstructorDetails;
import com.talha.springboot.app.repository.IInstructorDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorDetailsService implements IInstructorDetailsService {
    @Autowired
    private IInstructorDetailsRepository m_repository;

    @Override
    public InstructorDetails findById(int id) {
        return m_repository.findById(id).get();
    }

    @Override
    public void deleteById(int var1) {
        m_repository.deleteById(var1);
    }
}
