package com.talha.app.deviceswebapp.jsp;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import org.csystem.util.db.service.ServiceException;
import com.talha.app.deviceapp.repository.DevicesRepository;
import com.talha.entityLib.Device;
import com.talha.serviceLib.devicesapp.DeviceService;




public class DevicesWebAppJSP {
	
	private static final DeviceService ms_service = new DeviceService(DevicesRepository.INSTANCE);

	private DevicesWebAppJSP() {
	}

	public static void insertDevice(HttpServletRequest request, JspWriter out) throws IOException {
		if (request.getMethod().equals("POST")) {
			try {
				String name = request.getParameter("name");
				String host =request.getParameter("host");
				
				Device device = new Device(name,host);
				ms_service.save(device);
				out.print(String.format("<h4>%s</h4>", device));
				
				
			}
			catch(ServiceException ex) {
				out.print(String.format("<h3>Exception Message:%s</h3>", ex.getMessage()));
			}
		} else {
			out.print("sadece post ile işlem yapılabilir");
		}
		printDevicesAsTable(request, out);
	}
	
	private static void printDevicesAsTable(HttpServletRequest request, JspWriter out) throws IOException
	{
		out.print("<table border=\"1\">");		
		
		out.print("<tr>");
		out.print("<th>Device Id</th>");		
		out.print("<th>Name</th>");
		out.print("<th>Host</th>");		
		out.print("</tr>");
		
		for (var device : ms_service.findAll()) {
			out.print("<tr>");
			out.print(String.format("<td>%s</td>", device.getId()));
			out.print(String.format("<td>%s</td>", device.getName()));
			out.print(String.format("<td>%s</td>", device.getHost()));
			out.print("</tr>");
		}
		
		out.print("</table>");
	}
	

}
