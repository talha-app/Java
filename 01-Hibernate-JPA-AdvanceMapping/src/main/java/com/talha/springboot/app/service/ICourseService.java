package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Course;

import java.util.List;

public interface ICourseService {
    Course save(Course course);
  //  List<Course> findByInstructor_Id(int id);
    Course findById(int id);
    List<Course> findCoursesByInstructorId(int id);
    List<Course> findAllById(Iterable<Integer> idS);
}
