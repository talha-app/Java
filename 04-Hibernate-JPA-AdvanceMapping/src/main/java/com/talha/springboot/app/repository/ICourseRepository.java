package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ICourseRepository extends CrudRepository<Course, Integer> {

    @Query(value="select * from Course c where c.instructor_id=?1" ,nativeQuery =true)
    List<Course> findCoursesByInstructorId(int id);
}
