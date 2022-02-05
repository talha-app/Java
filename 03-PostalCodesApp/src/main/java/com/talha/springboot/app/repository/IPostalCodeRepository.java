package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.PostalCodeInfo;
import org.springframework.data.repository.CrudRepository;

public interface IPostalCodeRepository extends CrudRepository<PostalCodeInfo, Long> {
    boolean existsByPostalCodeAndCountryCode(String postalCode, String countryCode);
    Iterable<PostalCodeInfo> findByPostalCodeAndCountryCode(String postalCode, String countryCode);
}
