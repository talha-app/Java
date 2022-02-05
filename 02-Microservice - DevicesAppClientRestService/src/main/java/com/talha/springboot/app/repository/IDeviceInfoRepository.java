package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.DeviceInfo;
import org.springframework.data.repository.CrudRepository;

public interface IDeviceInfoRepository extends CrudRepository<DeviceInfo , String> {
}
