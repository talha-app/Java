package com.talha.springboot.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int m_id;

    @Column(name = "comment")
    private String m_comment;

    public Review(String comment) {
        m_comment = comment;
    }

    public Review() {
    }

    public int getId() {
        return m_id;
    }

    public void setId(int id) {
        m_id = id;
    }

    public String getComment() {
        return m_comment;
    }

    public void setComment(String comment) {
        m_comment = comment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "m_id=" + m_id +
                ", m_comment='" + m_comment + '\'' +
                '}';
    }
}
