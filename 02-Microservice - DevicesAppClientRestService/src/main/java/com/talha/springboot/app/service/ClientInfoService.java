package com.talha.springboot.app.service;

import com.talha.springboot.app.entity.ClientInfo;
import com.talha.springboot.app.repository.IClientInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientInfoService implements IClientInfoService {

    @Autowired
    private IClientInfoRepository m_clientInfoRepository;

    @Override
    public ClientInfo save(ClientInfo clientInfo) {
        return m_clientInfoRepository.save(clientInfo);
    }
}
