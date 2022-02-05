package com.talha.springboot.app.viewmodel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public class DeviceViewModel {
    private String name;
    private String m_host;
    private LocalDateTime m_insertDate;

    public DeviceViewModel() {
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public LocalDateTime getInsertDate() {
        return this.m_insertDate;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public void setInsertDate(LocalDateTime insertDate) {
        this.m_insertDate = insertDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return this.m_host;
    }

    public void setHost(String host) {
        this.m_host = host;
    }

    @Override
    public String toString() {
        return "DeviceViewModel{" +
                "name='" + name + '\'' +
                ", m_host='" + m_host + '\'' +
                ", m_insertDate=" + m_insertDate +
                '}';
    }
}
