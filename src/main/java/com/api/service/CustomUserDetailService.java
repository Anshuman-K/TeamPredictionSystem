package com.api.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.api.DTO.RegisteredUserDTO;
import com.api.config.CustomUserDetail;
import com.api.entity.RegisteredUserEntity;
import com.api.repository.RegisteredUserRepository;
import com.api.token.ConfirmationToken;
import com.api.token.ConfirmationTokenService;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	private final static String USER_NOT_FOUND = "User With UserName %s Not Found";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<RegisteredUserEntity> user = registeredUserRepository.findById(username);
		RegisteredUserEntity userDetail = user.get();
		RegisteredUserDTO findUserDetails = RegisteredUserEntity.prepareDTO(userDetail);
		if(findUserDetails == null) {
			throw new  UsernameNotFoundException(String.format(USER_NOT_FOUND, username));
		}
		return new CustomUserDetail(findUserDetails);
	}
	
	public String signUpUser(RegisteredUserDTO registeredUserDTO) {
		boolean userNameExists = registeredUserRepository.findById(registeredUserDTO.getUserName()).isPresent();
		if(userNameExists) {
			 return "UserName Already Taken";
		}
				
		registeredUserDTO.setPassword(this.bCryptPasswordEncoder.encode(registeredUserDTO.getPassword()));
		RegisteredUserEntity value = RegisteredUserDTO.prepareEntity(registeredUserDTO);
		registeredUserRepository.save(value);
		
		String token = UUID.randomUUID().toString();
		ConfirmationToken confirmationToken = new ConfirmationToken(
				token,
				LocalDateTime.now(),
				LocalDateTime.now().plusMinutes(15),
				value
				);
		confirmationTokenService.saveConfirmationToken(confirmationToken);
		return token;
	}
	
    public int enableAppUser(String email) {
        return registeredUserRepository.enableAppUser(email);
    }
}
