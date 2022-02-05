package com.talha.springboot.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private Integer m_id;

    @Column(name = "first_name")
    private String m_firstName;

    @Column(name = "last_name")
    private String m_lastName;

    @Column(name = "email")
    private String m_email;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetails m_instructorDetails;

    @Override
    public String toString() {
        return "Instructor{" +
                "m_id=" + m_id +
                ", m_firstName='" + m_firstName + '\'' +
                ", m_lastName='" + m_lastName + '\'' +
                ", m_email='" + m_email + '\'' +
                ", m_courseList=" + m_courseList +
                '}';
    }

    @OneToMany(mappedBy = "m_instructor",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch = FetchType.LAZY)
    private List<Course> m_courseList;

    public List<Course> getCourseList() {
        return m_courseList;
    }

    public void setCourseList(List<Course> courseList) {
        m_courseList = courseList;
    }

    public void addCourse(Course course){
        if (m_courseList == null) {
            m_courseList= new ArrayList<>();
        }
        m_courseList.add(course);
        course.setInstructor(this);
    }

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String email) {
        m_firstName = firstName;
        m_lastName = lastName;
        m_email = email;
    }

    public Instructor(Integer id, String firstName, String lastName, String email) {
        m_id = id;
        m_firstName = firstName;
        m_lastName = lastName;
        m_email = email;
    }

    public Integer getId() {
        return m_id;
    }

    public void setId(Integer id) {
        m_id = id;
    }

    public String getFirstName() {
        return m_firstName;
    }

    public void setFirstName(String firstName) {
        m_firstName = firstName;
    }

    public String getLastName() {
        return m_lastName;
    }

    public void setLastName(String lastName) {
        m_lastName = lastName;
    }

    public String getEmail() {
        return m_email;
    }

    public void setEmail(String email) {
        m_email = email;
    }



}
