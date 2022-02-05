package com.talha.springboot.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

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

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
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
        return "Customer{" +
                "m_id=" + m_id +
                ", m_firstName='" + m_firstName + '\'' +
                ", m_lastName='" + m_lastName + '\'' +
                ", m_email='" + m_email + '\'' +
                '}';
    }
}
