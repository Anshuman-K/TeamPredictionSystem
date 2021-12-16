package com.api.DTO;

import org.springframework.stereotype.Component;
import com.api.entity.RegisteredUserEntity;

@Component
public class RegisteredUserDTO {
	private String userName;
	private String name;
	private String password;
	private String email;
	private AppUserRole appUserRole;
	private Boolean locked = false;
	private Boolean enabled = false;
	
	public RegisteredUserDTO() {}
	
	public RegisteredUserDTO(String userName, String name, String password, String email,
			AppUserRole appUserRole) {
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
		return "RegisteredUserDTO [userName=" + userName + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", appUserRole=" + appUserRole
				+ ", locked=" + locked + ", enabled=" + enabled + "]";
	}

	public static RegisteredUserEntity prepareEntity(RegisteredUserDTO registeredUserDTO) {
		RegisteredUserEntity value = new RegisteredUserEntity();
		value.setEmail(registeredUserDTO.getEmail());
		value.setPassword(registeredUserDTO.getPassword());
		value.setAppUserRole(registeredUserDTO.getAppUserRole());
		value.setEnabled(registeredUserDTO.getEnabled());
		value.setLocked(registeredUserDTO.getLocked());
		value.setUserName(registeredUserDTO.getUserName());
		value.setName(registeredUserDTO.getName());
	    return value;
	}
	
}
