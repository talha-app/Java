package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Review;

import java.util.List;

public interface IReviewService {
    Review findById(int id);
    List<Review> findCoursesByInstructorId(int id);
    Review save(Review review);

}
