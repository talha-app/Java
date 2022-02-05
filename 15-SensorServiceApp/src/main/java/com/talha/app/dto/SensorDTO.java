package com.talha.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SensorDTO {
    private String name;
    private LocalDate registerDate;
    private boolean active;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getRegisterDate()
    {
        return registerDate;
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    public void setRegisterDate(LocalDate registerDate)
    {
        this.registerDate = registerDate;
    }

    public boolean isActive()
    {
        return active;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
}
