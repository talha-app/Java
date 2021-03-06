package com.talha.app.deviceapp.repositorytest;

import java.util.Scanner;

import com.talha.app.deviceapp.repository.IDeviceRepository;

public class FindDeviceByIdTest {
	private final IDeviceRepository m_repository;

	public FindDeviceByIdTest(IDeviceRepository repository) {
		m_repository = repository;
	}

	public void run() {
		try {
			@SuppressWarnings("resource")
			Scanner kb = new Scanner(System.in);
			for (;;) {
				int id = Integer.parseInt(kb.next());
				if (id == 0)
					break;
				var op = m_repository.findById(id);
				if (op.isPresent())
					System.out.println(op.get());
				else
					System.out.println("Cihaz bulunamadi");
			}
		} catch (Throwable ex) {
			System.err.println(ex.getMessage());

		}
	}

}
