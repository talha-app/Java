package com.talha.springboot.app.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
public class ClientInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private long m_id;

    @Column(name = "host",nullable = false)
    private String m_host;

    @Column(name = "device_name",nullable = false)
    private String m_deviceName;

    @Column(name = "query_date",nullable = false)
    private LocalDateTime m_queryDate =LocalDateTime.now();

    @Column(name = "found",nullable = false)
    private boolean m_found;

    public ClientInfo() {
    }

    public ClientInfo(String host, String deviceName,boolean found) {
        m_host=host;
        m_deviceName=deviceName;
        m_found=found;
    }
}
