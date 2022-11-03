package com.talha.app.Pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Person implements Serializable {

    private int id;
    private String name;
    private String surname;
    private boolean isVip;
    private LocalDateTime recordDate = LocalDateTime.now();

    public Person(int id, String name, String surname, boolean isVip)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isVip = isVip;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public boolean isVip()
    {
        return isVip;
    }

    public void setVip(boolean vip)
    {
        isVip = vip;
    }

    public LocalDateTime getRecordDate()
    {
        return recordDate;
    }

    public void setRecordDate(LocalDateTime recordDate)
    {
        this.recordDate = recordDate;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isVip=" + isVip +
                ", recordDate=" + recordDate +
                '}';
    }
}
