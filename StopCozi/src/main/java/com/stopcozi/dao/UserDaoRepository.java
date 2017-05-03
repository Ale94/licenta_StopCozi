package com.stopcozi.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.stopcozi.domain.User;

//can extend CRUDRepository too, and not sure if the repository annotation is needed, neither the collection.. 
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserDaoRepository extends JpaRepository<User, Long>{
	
	//@Param??? , not sure what does mean and I guess they are not needed
	User findByUsername(@Param("username") String username);
	User findByEmail(@Param("email") String email);
	List<User> findAll();

}
