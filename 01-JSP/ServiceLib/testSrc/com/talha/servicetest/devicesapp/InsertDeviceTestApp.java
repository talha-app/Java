package com.talha.servicetest.devicesapp;

import com.talha.app.deviceapp.repository.DevicesRepository;
import com.talha.serviceLib.devicesapp.DeviceService;
import com.talha.serviceLib.devicesapp.IDeviceService;

public class InsertDeviceTestApp {
	
	public static void main(String []args) {
		IDeviceService service = new DeviceService(DevicesRepository.INSTANCE);
		InsertDeviceTest test = new InsertDeviceTest(service);		
		
		test.run();
	}

}
