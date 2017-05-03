package com.stopcozi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.security.Role;

@RepositoryRestResource
public interface RoleDaoRepository extends CrudRepository<Role, Integer> {

	Role findByName(String name);
}
