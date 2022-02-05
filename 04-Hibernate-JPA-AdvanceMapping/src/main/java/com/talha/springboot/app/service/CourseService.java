package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Course;
import com.talha.springboot.app.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private ICourseRepository m_repository;

    @Override
    public Course save(Course course) {
        return m_repository.save(course);
    }

    @Override
    public Course findById(int id) {
        return m_repository.findById(id).get();
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        return m_repository.findCoursesByInstructorId(id);
    }

    @Override
    public List<Course> findAllById(Iterable<Integer> idS) {
        var iterable =  m_repository.findAllById(idS);
        return StreamSupport.stream(iterable.spliterator(),false).collect(Collectors.toList());
    }
}
