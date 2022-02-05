package com.talha.servicetest.devicesapp;

import java.util.Scanner;

import org.csystem.util.db.service.ServiceException;

import com.talha.entityLib.Device;
import com.talha.serviceLib.devicesapp.IDeviceService;

public class InsertDeviceTest {
	private final IDeviceService m_deviceService;

	public InsertDeviceTest(IDeviceService deviceService) {
		m_deviceService = deviceService;
	}
	
	public void run(){
		try {
			@SuppressWarnings("resource")
			Scanner kb = new Scanner(System.in);
			for(;;) {
				System.out.println("Tüm cihazlar:");
				m_deviceService.findAll().forEach(System.out::println);
				String name = kb.nextLine();
				
				if (name.equals("quit"))
					break;
				
				System.out.print("IP giriniz:");
				String host = kb.nextLine();
				var device = new Device(name, host);
				System.out.printf("Device:%s%n", m_deviceService.save(device));
			}
			
		}
		catch (Throwable ex) {
			System.err.println(ex.getMessage());
		}
	}

}
