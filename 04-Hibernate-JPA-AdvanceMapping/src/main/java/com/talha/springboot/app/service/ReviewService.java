package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.Review;
import com.talha.springboot.app.repository.IReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements IReviewService {
    @Autowired
    private IReviewRepository m_repository;

    @Override
    public Review findById(int id) {
        return m_repository.findById(id).get();
    }

    @Override
    public List<Review> findCoursesByInstructorId(int id) {
        return m_repository.findCoursesByInstructorId(id);
    }

    @Override
    public Review save(Review review) {
        return m_repository.save(review);
    }
}
