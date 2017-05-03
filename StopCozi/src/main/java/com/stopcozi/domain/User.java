package com.stopcozi.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stopcozi.domain.security.Authority;
import com.stopcozi.domain.security.UserRole;

@Entity 
public class User implements UserDetails {
	
	private String firstName;
	private String lastName;
	private String password;
	@Id
	@GeneratedValue (strategy= GenerationType.AUTO)
	@Column(name = "userId", nullable = false, updatable = false)
	private Long userId;
	private String email;
	private String phone;
	private String PIN;
	private String username;
	
	private boolean enabled=true;

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles=new HashSet<UserRole>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference
	private List<Appointment> appointmentList;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference
	private List<UploadDocs> uploadFileList;
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getUserId() {
		return userId;
	}
	public void Long(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPIN() {
		return PIN;
	}
	public void setPIN(String PIN) {
		this.PIN = PIN;
	}
	public List<Appointment> getAppointments() {
		return appointmentList;
	}
	public void setAppointments(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	 public List<UploadDocs> getUploadFileList() {
		return uploadFileList;
	}
	public void setUploadFileList(List<UploadDocs> uploadFileList) {
		this.uploadFileList = uploadFileList;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
	    userRoles.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
	    return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
	    // TODO Auto-generated method stub
	     return true;
	 }

	@Override
	public boolean isAccountNonLocked() {
	    // TODO Auto-generated method stub
	    return true;
	}

	    @Override
	    public boolean isCredentialsNonExpired() {
	        // TODO Auto-generated method stub
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return enabled;
	    }
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		
		@Override
		public String toString() {
			return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", userId="
					+ userId + ", email=" + email + ", phone=" + phone + ", PIN=" + PIN + ", username=" + username
					+ ", enabled=" + enabled + ", userRoles=" + userRoles + ", appointmentList=" + appointmentList
					+ ", uploadFileList=" + uploadFileList + "]";
		}
	    


	

}
