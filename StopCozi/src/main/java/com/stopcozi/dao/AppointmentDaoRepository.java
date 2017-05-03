package com.stopcozi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.Appointment;

@RepositoryRestResource
public interface AppointmentDaoRepository extends CrudRepository<Appointment, Long> {

	List<Appointment> findAll();
}
