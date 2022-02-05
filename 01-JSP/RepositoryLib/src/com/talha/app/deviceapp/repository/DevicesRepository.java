package com.talha.app.deviceapp.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import org.csystem.util.db.repository.RepositoryException;

import static com.talha.app.deviceapp.repository.ConnectionInfo.*;

import com.talha.entityLib.Device;

public enum DevicesRepository implements IDeviceRepository {
	
	INSTANCE;

	//SQL Statements
	private static String INSERT_DEVICE = "insert into devices (name, host) values (?, ?)";
	private static String FIND_ALL_DEVICES = "select * from devices";
	//private static String FIND_BY_LIMIT = "select * from devices limit ?";
	private static String FIND_BY_ID = "select * from devices where device_id=?";
	private static String FIND_BY_NAME = "select * from devices where name like ?";
	private static String GET_COUNT = "select count(*) from devices";
	
	private static Connection getConnection() throws SQLException
	{
		var con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		
		return con;				
	}	
	
	private static PreparedStatement getPreparedStatement(Connection con, String sqlStr) throws SQLException
	{
		return con.prepareStatement(sqlStr);
	}
	
	private static Device getDevice(ResultSet rs) throws SQLException
	{
		var id = rs.getInt(1);
		var name = rs.getString(2);
		var host = rs.getString(3);
		
		return new Device(id, name, host);		
	}	
	
	
	private static <S extends Device> S saveProc(Connection con, S device) throws SQLException
	{
		try (var stmt = con.prepareStatement(INSERT_DEVICE, Statement.RETURN_GENERATED_KEYS)) {			
			con.setAutoCommit(false);
			stmt.setString(1, device.getName());
			stmt.setString(2, device.getHost());
			
			stmt.executeUpdate();
			
			ResultSet rsKeys = stmt.getGeneratedKeys();
			
			rsKeys.next();
			
			var id = rsKeys.getInt(1);
			
			device.setId(id);			
			
			con.commit();
			
			return device;
		}
		catch (Throwable ex) {			
			con.rollback();			
			throw new RepositoryException("exception:Repository saveProc", ex);
		}		
	}
		
	@Override
	public Optional<Device> findByName(String name) 
	{		
		try (var con = getConnection(); var stmt = getPreparedStatement(con, FIND_BY_NAME)) {			
			stmt.setString(1, name);
			
			ResultSet resultSet = stmt.executeQuery();
			
			return resultSet.next() ? Optional.of(getDevice(resultSet)) : Optional.empty();
		}
		catch (Throwable ex) {
			//...
			throw new RepositoryException("exception:Repository findByName", ex);
		}						
	}

	@Override
	public Iterable<Device> findAll()
	{
		try (var con = getConnection();
				var stmt = getPreparedStatement(con, FIND_ALL_DEVICES)) {
			
			ResultSet resultSet = stmt.executeQuery();
			
			ArrayList<Device> devices = new ArrayList<>();
			
			while (resultSet.next())
				devices.add(getDevice(resultSet));			
			
			return devices;					
		}
		catch (Throwable ex) {
			//...
			throw new RepositoryException("exception:Repository findAll", ex);
		}		
	}
	
	@Override
	public Optional<Device> findById(Integer id)
	{
		try (var con = getConnection();
				var stmt = getPreparedStatement(con, FIND_BY_ID)) {
			
			stmt.setInt(1, id);
			
			ResultSet resultSet = stmt.executeQuery();
			
			return resultSet.next() ? Optional.of(getDevice(resultSet)) : Optional.empty();
		}
		catch (Throwable ex) {
			//...
			throw new RepositoryException("exception:Repository findById", ex);
		}			
	}

	@Override
	public <S extends Device> S save(S device) 
	{		
		try (var con = getConnection()) {
			return saveProc(con, device);				
		}
		catch (RepositoryException ex) {
			throw ex;
		}
		catch (Throwable ex) {						
			throw new RepositoryException("exception:Repository save", ex);
		}
	}
		
	@Override
	public long count() 
	{
		try (var con = getConnection(); var stmt = getPreparedStatement(con, GET_COUNT)) {
			var rs = stmt.executeQuery();
			rs.next();
			
			return rs.getInt(1);			
		}	
		catch (Throwable ex) {
			throw new RepositoryException("exception:Repository count", ex);
		}
	}

	@Override
	public void delete(Device arg0) 
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void deleteAll() 
	{
		throw new UnsupportedOperationException();		
	}

	@Override
	public void deleteAll(Iterable<? extends Device> arg0) 
	{
		throw new UnsupportedOperationException();		
	}

	@Override
	public void deleteById(Integer arg0) 
	{
		throw new UnsupportedOperationException();				
	}

	@Override
	public boolean existsById(Integer arg0)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public Iterable<Device> findAllById(Iterable<Integer> arg0)
	{
		throw new UnsupportedOperationException();
	}
	

	@Override
	public <S extends Device> Iterable<S> saveAll(Iterable<S> arg0)
	{
		throw new UnsupportedOperationException();
	}

	
}
