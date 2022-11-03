package com.talha.springboot.app.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int m_id;

    @Column(name = "first_name")
    private String m_firstName;

    @Column(name = "last_name")
    private String m_lastName;

    @Column(name = "email")
    private String m_email;

    @ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> m_courseList;

    public void addCourse(Course course) {
        if (m_courseList == null) {
            m_courseList = new ArrayList<>();
        }
        m_courseList.add(course);
    }

    public List<Course> getCourseList() {
        return m_courseList;
    }

    public void setCourseList(List<Course> courseList) {
        m_courseList = courseList;
    }

    public Student() {
    }

    public Student(String firstName, String lastName, String email) {
        m_firstName = firstName;
        m_lastName = lastName;
        m_email = email;
    }

    public int getId() {
        return m_id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "Student{" +
                "m_id=" + m_id +
                ", m_firstName='" + m_firstName + '\'' +
                ", m_lastName='" + m_lastName + '\'' +
                ", m_email='" + m_email + '\'' +
                '}';
    }
}
