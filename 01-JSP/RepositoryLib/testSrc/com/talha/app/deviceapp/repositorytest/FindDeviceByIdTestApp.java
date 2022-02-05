package com.talha.app.deviceapp.repositorytest;

import com.talha.app.deviceapp.repository.DevicesRepository;

public class FindDeviceByIdTestApp {
	public static void main(String [] args)
	{
		FindDeviceByIdTest test = new FindDeviceByIdTest(DevicesRepository.INSTANCE);
		
		test.run();
	}
}
