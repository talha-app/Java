package com.talha.springboot.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_details")
public class InstructorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer m_id;

    @Column(name = "youtube")
    private String m_youtube;

    @Column(name = "hobby")
    private String m_hobby;

    @OneToOne(mappedBy = "m_instructorDetails", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor m_instructor;

    public Instructor getInstructor() {
        return m_instructor;
    }

    public void setInstructor(Instructor instructor) {
        m_instructor = instructor;
    }

    public InstructorDetails() {
    }

    public InstructorDetails(String youtube, String hobby) {
        this(0,youtube,hobby);
    }

    public InstructorDetails(Integer id, String youtube, String hobby) {
        m_id = id;
        m_youtube = youtube;
        m_hobby = hobby;
    }

    public Integer getId() {
        return m_id;
    }

    public void setId(Integer id) {
        m_id = id;
    }

    public String getYoutube() {
        return m_youtube;
    }

    public void setYoutube(String youtube) {
        m_youtube = youtube;
    }

    public String getHobby() {
        return m_hobby;
    }

    public void setHobby(String hobby) {
        m_hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetails{" +
                "m_id=" + m_id +
                ", m_youtube='" + m_youtube + '\'' +
                ", m_hobby='" + m_hobby + '\'' +
                '}';
    }
}
