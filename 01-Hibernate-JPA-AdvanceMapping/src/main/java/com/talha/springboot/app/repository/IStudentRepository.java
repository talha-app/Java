package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IStudentRepository extends CrudRepository<Student,Integer> {
    @Query(value="select * from student s where s.student_id=?1" ,nativeQuery =true)
    List<Student> findStudentsById(int id);

    @Query(value="select c.id from course c where c.id in (select cs.course_id from course_student cs where cs.student_id=?1)" ,nativeQuery =true)
    List<Integer> findCoursesById(Integer id);


}
