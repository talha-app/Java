package com.talha.serviceLib.devicesapp;

import java.util.List;

import com.talha.entityLib.Device;

public interface IDeviceService {
	Device save(Device device);
	List<Device> findAll();
	
}
