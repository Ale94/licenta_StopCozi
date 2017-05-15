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
	private String cnp;
	private String username;
	private String dad;
	private String mum;
	private String domiciliuActual;
	private String domiciliuNastere;
	private String judetActual;
	private String judetNastere;
	private String strada;
	private String bloc;
	private String apartament;
	private String numar;
	private String seria;
	private String nr;
	private String anulNasterii;
	private String ziuaNasterii;
	private String lunaNasterii;
	
	private boolean enabled=true;

	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<UserRole> userRoles=new HashSet<UserRole>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JsonManagedReference
	private List<Appointment> appointmentList;
	
	/**
	 * If I use CASCADE the delete method CRUD, doesn't work, couldn't find an answer why it doesn't work.
	 * Some guy tried with CASCADE persist and refresh, but for me didn't work. :( 
	 * Why? I've mappedBy user.
	 * What if I want to delete the user, of course all his documents should be deleted too.(CASCADE)
	 */
	// cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.REFRESH},
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	@JsonIgnore
	@JsonManagedReference
    private List<UploadFile> uploadFiles;
	
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
	public String getCnp() {
		return cnp;
	}
	public void setCnp(String cnp) {
		this.cnp = cnp;
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
	
	 public List<UploadFile> getUploadFileList() {
		return uploadFiles;
	}
	public void setUploadFileList(List<UploadFile> uploadFiles) {
		this.uploadFiles = uploadFiles;
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
		public String getDad() {
			return dad;
		}
		public void setDad(String dad) {
			this.dad = dad;
		}
		public String getMum() {
			return mum;
		}
		public void setMum(String mum) {
			this.mum = mum;
		}
		
		public String getJudetActual() {
			return judetActual;
		}
		public void setJudetActual(String judetActual) {
			this.judetActual = judetActual;
		}
		public String getJudetNastere() {
			return judetNastere;
		}
		public void setJudetNastere(String judetNastere) {
			this.judetNastere = judetNastere;
		}
		public String getStrada() {
			return strada;
		}
		public void setStrada(String strada) {
			this.strada = strada;
		}
		public String getBloc() {
			return bloc;
		}
		public void setBloc(String bloc) {
			this.bloc = bloc;
		}
		public String getApartament() {
			return apartament;
		}
		public void setApartament(String apartament) {
			this.apartament = apartament;
		}
		public String getNumar() {
			return numar;
		}
		public void setNumar(String numar) {
			this.numar = numar;
		}
		public String getSeria() {
			return seria;
		}
		public void setSeria(String seria) {
			this.seria = seria;
		}
		public String getNr() {
			return nr;
		}
		public void setNr(String nr) {
			this.nr = nr;
		}
		public String getAnulNasterii() {
			return anulNasterii;
		}
		public void setAnulNasterii(String anulNasterii) {
			this.anulNasterii = anulNasterii;
		}
		public String getZiuaNasterii() {
			return ziuaNasterii;
		}
		public void setZiuaNasterii(String ziuaNasterii) {
			this.ziuaNasterii = ziuaNasterii;
		}
		public String getLunaNasterii() {
			return lunaNasterii;
		}
		public void setLunaNasterii(String lunaNasterii) {
			this.lunaNasterii = lunaNasterii;
		}
		public List<Appointment> getAppointmentList() {
			return appointmentList;
		}
		public void setAppointmentList(List<Appointment> appointmentList) {
			this.appointmentList = appointmentList;
		}
		public List<UploadFile> getUploadFiles() {
			return uploadFiles;
		}
		public void setUploadFiles(List<UploadFile> uploadFiles) {
			this.uploadFiles = uploadFiles;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getDomiciliuActual() {
			return domiciliuActual;
		}
		public void setDomiciliuActual(String domiciliuActual) {
			this.domiciliuActual = domiciliuActual;
		}
		public String getDomiciliuNastere() {
			return domiciliuNastere;
		}
		public void setDomiciliuNastere(String domiciliuNastere) {
			this.domiciliuNastere = domiciliuNastere;
		}
		@Override
		public String toString() {
			return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", userId="
					+ userId + ", email=" + email + ", phone=" + phone + ", cnp=" + cnp + ", username=" + username
					+ ", dad=" + dad + ", mum=" + mum + ", domiciliuActual=" + domiciliuActual + ", domiciliuNastere="
					+ domiciliuNastere + ", judetActual=" + judetActual + ", judetNastere=" + judetNastere + ", strada="
					+ strada + ", bloc=" + bloc + ", apartament=" + apartament + ", numar=" + numar + ", seria=" + seria
					+ ", nr=" + nr + ", anulNasterii=" + anulNasterii + ", ziuaNasterii=" + ziuaNasterii
					+ ", lunaNasterii=" + lunaNasterii + ", enabled=" + enabled + ", userRoles=" + userRoles
					+ ", appointmentList=" + appointmentList + ", uploadFiles=" + uploadFiles + "]";
		}
		
	

}
