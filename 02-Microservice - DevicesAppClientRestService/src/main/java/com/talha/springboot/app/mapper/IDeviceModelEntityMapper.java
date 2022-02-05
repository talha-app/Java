package com.talha.springboot.app.mapper;

import com.talha.springboot.app.entity.DeviceInfo;
import com.talha.springboot.app.viewmodel.DeviceViewModel;
import org.mapstruct.Mapper;

@Mapper(implementationName = "IDeviceModelEntityMapperImpl",componentModel = "spring")
public interface IDeviceModelEntityMapper {
    DeviceInfo viewModelToEntity(DeviceViewModel deviceViewModel);
    DeviceViewModel entityToViewModel(DeviceInfo deviceInfo);
}
