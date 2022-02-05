package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReviewRepository extends CrudRepository<Review,Integer> {
    @Query(value="select * from Review r where r.course_id=?1" ,nativeQuery =true)
    List<Review> findCoursesByInstructorId(int id);

}
