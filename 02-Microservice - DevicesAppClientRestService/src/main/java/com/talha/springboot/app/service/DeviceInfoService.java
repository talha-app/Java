package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.ClientInfo;
import com.talha.springboot.app.entity.DeviceInfo;
import com.talha.springboot.app.mapper.IDeviceModelEntityMapper;
import com.talha.springboot.app.repository.IClientInfoRepository;
import com.talha.springboot.app.repository.IDeviceInfoRepository;
import com.talha.springboot.app.viewmodel.DeviceViewModel;
import com.talha.springboot.app.viewmodel.DevicesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
//@EnableAutoConfiguration
public class DeviceInfoService implements IDeviceInfoService {

    private final IDeviceInfoRepository m_repository;
    private final IDeviceModelEntityMapper m_deviceModelEntityMapper;
    private final RestTemplate m_restTemplate;
    private final HttpServletRequest m_httpServletRequest;
    @Autowired
    private IClientInfoService m_clientInfoService;
    @Value("${devicesapp.url}")
    private String m_url;

    public DeviceInfoService(IDeviceInfoRepository repository,
                             IDeviceModelEntityMapper deviceModelEntityMapper,
                             RestTemplate restTemplate,
                             HttpServletRequest httpServletRequest,
                             IClientInfoRepository iClientInfoRepository)
    {
        m_repository = repository;
        m_deviceModelEntityMapper = deviceModelEntityMapper;
        m_restTemplate = restTemplate;
        m_httpServletRequest = httpServletRequest;
    }

    public void saveClientInfo(DeviceInfo devicesInfo,boolean found){
        if (devicesInfo==null)
            return;
        var ci = new ClientInfo(m_httpServletRequest.getRemoteHost(),devicesInfo.getName(),found);
        m_clientInfoService.save(ci);
    }
    @Override
    public Optional<DeviceViewModel> findByName(String name) {
        var optDeviceInfo = m_repository.findById(name);
        DeviceInfo deviceInfo = null;
        boolean found=false;

        if (optDeviceInfo.isPresent()) {
            deviceInfo= optDeviceInfo.get();
            found=true;
            saveClientInfo(deviceInfo,found);
            return Optional.of(m_deviceModelEntityMapper.entityToViewModel(deviceInfo));
        }
        var devicesInfo = m_restTemplate.getForObject(m_url + name,
                DevicesInfo.class);

        var result = devicesInfo.getDevices().stream().findFirst();

        if (result.isPresent()) {
            deviceInfo=m_deviceModelEntityMapper.viewModelToEntity(result.get());
            m_repository.save(deviceInfo);
        }
        saveClientInfo(deviceInfo,found);
        return result;
    }

    @Override
    public Iterable<DeviceInfo> findAll() {
        return m_repository.findAll();
    }

    @Override
    public DeviceInfo save(DeviceInfo di) {
        return m_repository.save(di);
    }

    @Override
    public void deleteById(String name) {
        m_repository.deleteById(name);
    }
}
