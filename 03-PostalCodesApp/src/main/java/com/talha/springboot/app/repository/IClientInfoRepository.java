package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.ClientInfo;
import org.springframework.data.repository.CrudRepository;

public interface IClientInfoRepository extends CrudRepository<ClientInfo, Long> {

}
