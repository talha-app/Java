package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.DeviceInfo;
import com.talha.springboot.app.viewmodel.DeviceViewModel;

import java.util.Optional;

public interface IDeviceInfoService {
    Optional<DeviceViewModel> findByName(String name);
    Iterable<DeviceInfo> findAll();
    DeviceInfo save(DeviceInfo di);
    void deleteById(String name);
}
