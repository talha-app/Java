package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Instructor;
import com.talha.springboot.app.repository.IInstructorRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService implements IInstructorService{

    @Autowired
    private IInstructorRepositoy m_service;

    @Override
    public void deleteById(int var1) {
    }

    @Override
    public Instructor save(Instructor instructor) {
       return m_service.save(instructor);
    }

    @Override
    public Instructor findById(Integer id) {
        return m_service.findById(id).get();
    }
}
