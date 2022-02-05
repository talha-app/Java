package com.talha.app.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "sensors")
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensorId")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Set<SensorData> getSensorData()
    {
        return sensorData;
    }

    public void setSensorData(Set<SensorData> sensorData)
    {
        this.sensorData = sensorData;
    }

    @Column(name = "registerDate", nullable = false)
    private LocalDate registerDate = LocalDate.now();

    @Column(name = "active", nullable = false)
    private boolean active;

    @OneToMany(mappedBy = "sensor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<SensorData> sensorData;

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

    public LocalDate getRegisterDate()
    {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate)
    {
        this.registerDate = registerDate;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
}
