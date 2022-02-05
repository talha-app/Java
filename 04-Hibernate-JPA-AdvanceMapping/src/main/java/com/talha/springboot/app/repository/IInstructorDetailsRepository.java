package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.InstructorDetails;
import org.springframework.data.repository.CrudRepository;

public interface IInstructorDetailsRepository extends CrudRepository<InstructorDetails,Integer> {

}
