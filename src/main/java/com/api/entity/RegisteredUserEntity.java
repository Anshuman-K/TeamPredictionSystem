package com.api.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import com.api.DTO.AppUserRole;
import com.api.DTO.RegisteredUserDTO;

@Entity
@Table(name="RegisteredUser")
public class RegisteredUserEntity {
	

	@Id
	private String userName;
	private String name;
	private String password;
	private String email;
	@Enumerated(EnumType.STRING)
	private AppUserRole appUserRole;
	private Boolean locked;
	private Boolean enabled;
	
	public RegisteredUserEntity() {}
	
	public RegisteredUserEntity(String userName, String name, String password,
			String email, AppUserRole appUserRole) {
		super();
		this.userName = userName;
		this.name = name;
		this.password = password;
		this.email = email;
		this.appUserRole = appUserRole;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public AppUserRole getAppUserRole() {
		return appUserRole;
	}

	public void setAppUserRole(AppUserRole appUserRole) {
		this.appUserRole = appUserRole;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	

	@Override
	public String toString() {
		return "RegisteredUserEntity [userName=" + userName + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", appUserRole=" + appUserRole
				+ ", locked=" + locked + ", enabled=" + enabled + "]";
	}

	public static RegisteredUserDTO prepareDTO(RegisteredUserEntity registeredUserEntity) {
		RegisteredUserDTO value = new RegisteredUserDTO();
		value.setEmail(registeredUserEntity.getEmail());
		value.setPassword(registeredUserEntity.getPassword());
		value.setAppUserRole(registeredUserEntity.getAppUserRole());
		value.setEnabled(registeredUserEntity.getEnabled());
		value.setLocked(registeredUserEntity.getLocked());
		value.setName(registeredUserEntity.getName());
		value.setUserName(registeredUserEntity.getUserName());
		return value;
	}
	
}
