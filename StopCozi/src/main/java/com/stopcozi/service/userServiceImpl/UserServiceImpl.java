package com.stopcozi.service.userServiceImpl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.stopcozi.dao.RoleDaoRepository;
import com.stopcozi.dao.UserDaoRepository;
import com.stopcozi.domain.Appointment;
import com.stopcozi.domain.User;
import com.stopcozi.domain.security.UserRole;
import com.stopcozi.service.UserService;

//maybe here will be annotated with 
@Service
@Transactional
public class UserServiceImpl implements UserService {

	
	/** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	/**
	 * the autowired is based on DI(dependency Injection)-> this means that when you need an instances, you
	 * will ask for it and spring boot will provide it for you(the container of spring boot)
	 */	
	@Autowired
	private UserDaoRepository userDao;
	
	@Autowired
	private RoleDaoRepository roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
		 
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public boolean checkUserExists(String username, String email) {
		if(checkUsernameExists(username) || checkEmailExists(email)){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean checkUsernameExists(String username) {
		if(null != findByUsername(username) ){
			return true;
		}
		return false;
	}
	

	@Override
	public boolean checkEmailExists(String email) {
		if(null != findByEmail(email)){
			return true;
		}
		return false;
	}

	@Override
	public void save(User user) {
		userDao.save(user);

	}
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles){
		User localUser=userDao.findByUsername(user.getUsername());
		if(localUser != null){
			LOG.info("User with username {} already exists. Nothing will be done.", user.getUsername());
		}
		else{
			
			String encryptedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			
			for (UserRole userRole : userRoles) {
				roleDao.save(userRole.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			
			localUser=userDao.save(user);
				
		}
		return localUser;
	}

	@Override
	public List<User> findUserList() {
		return userDao.findAll();
	}

	@Override
	public void enableUser(String username) {
		User user = userDao.findByUsername(username);
		user.setEnabled(true);
		userDao.save(user);

	}

	@Override
	public void disableUser(String username) {
		User user = userDao.findByUsername(username);
		user.setEnabled(false);
		System.out.println(user.isEnabled());
		userDao.save(user);
		System.out.println(username + " is disabled!");

		
	}

	@Override
	public List<Appointment> listAllAppointments(User user) {
		return user.getAppointments();
		
	}

}
