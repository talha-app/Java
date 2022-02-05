package com.talha.app.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "sensor_data")
public class SensorData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensorDataId")
    private long id;

    @Column(name = "value", nullable = false)
    private double value;

    @Column(name = "readDateTime", nullable = false)
    private LocalDateTime readDateTime = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sensorId", nullable = false)
    private Sensor sensor;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public LocalDateTime getReadDateTime()
    {
        return readDateTime;
    }

    public void setReadDateTime(LocalDateTime readDateTime)
    {
        this.readDateTime = readDateTime;
    }

    public Sensor getSensor()
    {
        return sensor;
    }

    public void setSensor(Sensor sensor)
    {
        this.sensor = sensor;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorData that = (SensorData) o;
        return Double.compare(that.value, value) == 0 && id == that.id && readDateTime.equals(that.readDateTime) && sensor.equals(that.sensor);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, value, readDateTime, sensor);
    }
}
