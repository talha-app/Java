package com.talha.app.service;

import com.talha.app.dal.SensorServiceHelper;
import com.talha.app.dto.SensorDTO;
import com.talha.app.mapper.ISensorDataMapper;
import com.talha.app.mapper.ISensorMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SensorAppService {
    private final SensorServiceHelper sensorServiceHelper;
    private final ISensorMapper sensorMapper;
    private final ISensorDataMapper sensorDataMapper;

    public SensorAppService(SensorServiceHelper sensorServiceHelper, ISensorMapper sensorMapper, ISensorDataMapper sensorDataMapper)
    {
        this.sensorServiceHelper = sensorServiceHelper;
        this.sensorMapper = sensorMapper;
        this.sensorDataMapper = sensorDataMapper;
    }

    @Profile("dev")
    public List<SensorDTO> findSensorByName(String name)
    {
        var sensors = sensorServiceHelper.getSensorByName(name);
        return StreamSupport.stream(sensors.spliterator(), true).map(sensorMapper::toSensorDTO).collect(Collectors.toList());
    }

    public List<SensorDTO> findSensorByNameContains(String text)
    {
        var sensors = sensorServiceHelper.getSensorByNameContains(text);
        return StreamSupport.stream(sensors.spliterator(), true).map(sensorMapper::toSensorDTO).collect(Collectors.toList());
    }
}
