package com.talha.app.repository;

import com.talha.app.entity.Sensor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SensorRepository extends CrudRepository<Sensor, Integer> {
    //@Query("select s from Sensor s where s.name like :name")
    Iterable<Sensor>findByName(String name);
    Iterable<Sensor> findByNameContains(String text);
}
