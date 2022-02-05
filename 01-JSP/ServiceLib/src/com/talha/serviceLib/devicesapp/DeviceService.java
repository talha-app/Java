package com.talha.serviceLib.devicesapp;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.csystem.util.db.repository.RepositoryException;
import org.csystem.util.db.service.ServiceException;

import com.talha.app.deviceapp.repository.IDeviceRepository;
import com.talha.entityLib.Device;

public class DeviceService implements IDeviceService {
	
	private final IDeviceRepository m_repository;
	
	public DeviceService (IDeviceRepository repository) {
		m_repository=repository;
	}
	
	@Override
	public Device save(Device device) {
		try {
			//...
			return m_repository.save(device);
		}
		catch (RepositoryException ex) {
			throw new ServiceException("exception:Service.save", ex.getCause());
		}
		catch (Throwable ex) {
			throw new ServiceException("exception:Service.save", ex);
		}
	}

	@Override
	public List<Device> findAll() {
		try {
			return StreamSupport.stream(m_repository.findAll().spliterator(), false)
					.collect(Collectors.toList());
		}
		catch(RepositoryException rex) {
			throw new ServiceException("serviceException:findAll:",rex.getCause());
			
		}
		catch(Throwable ex) {
			throw new RepositoryException("serviceException:findAll:",ex);
		}
	}
	

}
