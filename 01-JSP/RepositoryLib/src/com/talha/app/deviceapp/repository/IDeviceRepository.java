package com.talha.app.deviceapp.repository;

import java.util.Optional;

import org.csystem.util.db.repository.ICrudRepository;

import com.talha.entityLib.Device;

public interface IDeviceRepository extends ICrudRepository<Device, Integer> {
	
	Optional<Device> findByName(String name);
}
