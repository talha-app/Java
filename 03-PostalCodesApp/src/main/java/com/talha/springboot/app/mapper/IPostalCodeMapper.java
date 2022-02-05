package com.talha.springboot.app.mapper;

import com.talha.springboot.app.entity.PostalCodeInfo;
import com.talha.springboot.app.model.PostalCodeViewModel;
import org.mapstruct.Mapper;

@Mapper(implementationName = "PostalCodeMapperImpl", componentModel = "spring")
public interface IPostalCodeMapper {
    PostalCodeInfo viewModelToCodeInfo(PostalCodeViewModel postalCodeViewModel);
    PostalCodeViewModel codeInfoToViewModel(PostalCodeInfo postalCodeInfo);
}
