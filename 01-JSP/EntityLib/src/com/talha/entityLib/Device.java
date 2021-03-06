package com.talha.entityLib;

public class Device {
		
	public int m_id;
	public String m_name;
	public String m_host;
	public int getId() {
		return m_id;
	}
	public void setId(int id) {
		m_id = id;
	}
	public String getName() {
		return m_name;
	}
	public void setName(String name) {
		m_name = name;
	}
	public String getHost() {
		return m_host;
	}
	public void setHost(String host) {
		m_host = host;
	}
	
	public Device(int id, String name, String host) {

		m_id = id;
		m_name = name;
		m_host = host;
	}
	
	public Device(String name, String host) {
			this(0,name,host);
	}
	@Override
	public String toString() {
		return "Device [m_id=" + m_id + ", m_name=" + m_name + ", m_host=" + m_host + "]";
	}
	


}
