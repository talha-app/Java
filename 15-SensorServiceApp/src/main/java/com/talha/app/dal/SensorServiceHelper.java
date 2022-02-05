package com.talha.app.dal;

import com.talha.app.entity.Sensor;
import com.talha.app.repository.SensorDataRepository;
import com.talha.app.repository.SensorRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SensorServiceHelper {
    private final SensorRepository sensorRepository;
    private final SensorDataRepository sensorDataRepository;

    public SensorServiceHelper(SensorRepository sensorRepository, SensorDataRepository sensorDataRepository)
    {
        this.sensorRepository = sensorRepository;
        this.sensorDataRepository = sensorDataRepository;
    }

    @Profile("dev")
    public Iterable<Sensor> getAllSensors()
    {
        return sensorRepository.findAll();
    }

    public Iterable<Sensor> getSensorByName(String name)
    {
        return sensorRepository.findByName(name);
    }

    public Iterable<Sensor> getSensorByNameContains(String name)
    {
        return sensorRepository.findByNameContains(name);
    }

}
