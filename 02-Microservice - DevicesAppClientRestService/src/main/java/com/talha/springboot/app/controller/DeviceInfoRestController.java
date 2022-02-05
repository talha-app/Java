package com.talha.springboot.app.controller;


import com.talha.springboot.app.service.IDeviceInfoService;
import com.talha.springboot.app.viewmodel.DeviceViewModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("devices")
public class DeviceInfoRestController {

    private final IDeviceInfoService m_deviceInfoService;

    public DeviceInfoRestController(IDeviceInfoService m_deviceInfoService) {
        this.m_deviceInfoService = m_deviceInfoService;
    }

    @GetMapping("/names")
        public ResponseEntity<DeviceViewModel> findByName(@RequestParam("name") String name){
            return ResponseEntity.of(m_deviceInfoService.findByName(name));
    }
}
