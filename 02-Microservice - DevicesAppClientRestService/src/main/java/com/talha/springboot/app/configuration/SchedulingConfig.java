package com.talha.springboot.app.configuration;

import com.talha.springboot.app.mapper.IDeviceModelEntityMapper;
import com.talha.springboot.app.service.IDeviceInfoService;
import com.talha.springboot.app.viewmodel.DevicesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SchedulingConfig {
    @Autowired
    public IDeviceInfoService m_service;

    @Autowired
    public RestTemplate m_restTemplate;

    @Autowired
    public IDeviceModelEntityMapper m_entityMapper;

    @Value("${devicesapp.url}")
    private String m_url;

    @Scheduled(fixedRate = 60000)
    public void scheduleServiceDBUpdate() {
        m_service.findAll().forEach(device -> {
            var d =m_restTemplate.getForObject(m_url+device.getName(),
                    DevicesInfo.class);
            var result =d.getDevices().stream().findFirst();

            if (result.isPresent())
                m_service.save(m_entityMapper.viewModelToEntity(result.get()));
            else
                m_service.deleteById(device.getName());

        });
    }
}
