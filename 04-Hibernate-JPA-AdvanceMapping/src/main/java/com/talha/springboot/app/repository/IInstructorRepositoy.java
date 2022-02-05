package com.talha.springboot.app.repository;

import com.talha.springboot.app.entity.Instructor;
import org.springframework.data.repository.CrudRepository;

public interface IInstructorRepositoy extends CrudRepository<Instructor, Integer> {

}
