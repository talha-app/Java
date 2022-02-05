package com.talha.springboot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "devices")
public class DeviceInfo
{
    @Id
    @Column(name = "name")
    private String m_name;

    @Column(name = "host", nullable = false)
    private String m_host;

    @Column(name = "insert_date")
    private LocalDateTime m_insertDate;

    public String getHost() {
        return m_host;
    }

    public void setHost(String host) {
        m_host = host;
    }

    public LocalDateTime getInsertDate() {
        return m_insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        m_insertDate = insertDate;
    }

    public String getName() {
        return m_name;
    }

    public void setName(String name) {
        m_name = name;
    }
}
