package com.talha.springboot.app.service;


import com.talha.springboot.app.model.PostalCodeViewModel;

public interface IPostalCodeService {
    Iterable<PostalCodeViewModel> getPostalCode(String postalCode, String countryCode);
}
