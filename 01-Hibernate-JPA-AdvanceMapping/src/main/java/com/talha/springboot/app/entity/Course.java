package com.talha.springboot.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private int m_id;

    @Column(name = "title", unique = true, nullable = false)
    private String m_title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor m_instructor;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> m_reviewList;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> m_studentList;

    public void addStudent(Student student) {
        if (m_studentList == null) {
            m_studentList = new ArrayList<>();
        }
        m_studentList.add(student);
    }

    public List<Student> getStudentList() {
        return m_studentList;
    }

    public void setStudentList(List<Student> studentList) {
        m_studentList = studentList;
    }

    public void addReview(Review review) {
        if (m_reviewList == null) {
            m_reviewList = new ArrayList<>();
        }
        m_reviewList.add(review);
    }

    public List<Review> getReviewList() {
        return m_reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        m_reviewList = reviewList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "m_id=" + m_id +
                ", m_title='" + m_title + '\'' +
                '}';
    }

    public Course() {
    }

    public Course(String title) {
        m_title = title;
    }

    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        m_id = id;
    }

    public String getTitle() {
        return m_title;
    }

    public void setTitle(String title) {
        m_title = title;
    }

    public Instructor getInstructor() {
        return m_instructor;
    }

    public void setInstructor(Instructor instructor) {
        m_instructor = instructor;
    }
}
