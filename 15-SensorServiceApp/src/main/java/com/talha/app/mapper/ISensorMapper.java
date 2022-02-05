package com.talha.app.mapper;

import com.talha.app.dto.SensorDTO;
import com.talha.app.entity.Sensor;
import org.mapstruct.Mapper;

@Mapper(implementationName = "SensorMapperImpl", componentModel = "spring")
public interface ISensorMapper {
    Sensor toSensor(SensorDTO sensorDTO);
    SensorDTO toSensorDTO(Sensor sensor);
}
