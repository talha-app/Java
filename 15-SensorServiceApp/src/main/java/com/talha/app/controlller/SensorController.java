package com.talha.app.controlller;

import com.talha.app.dto.SensorDTO;
import com.talha.app.service.SensorAppService;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SensorController {

    private final SensorAppService sensorAppService;

    public SensorController(SensorAppService sensorAppService)
    {
        this.sensorAppService = sensorAppService;
    }

    @Profile("dev")
    @PostMapping("/findbyname")
    public ResponseEntity<List<SensorDTO>> findByName(@RequestParam String name)
    {
        return ResponseEntity.of(Optional.of(sensorAppService.findSensorByName(name)));
    }

    @PostMapping("/findbynamecontains")
    public ResponseEntity<List<SensorDTO>> findByNameContains(@RequestParam String name)
    {
        return ResponseEntity.of(Optional.of(sensorAppService.findSensorByNameContains(name)));
    }
}
