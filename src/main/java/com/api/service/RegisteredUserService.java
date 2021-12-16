package com.api.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.api.DTO.AppUserRole;
import com.api.DTO.RegisteredUserDTO;
import com.api.email.EmailSender;
import com.api.entity.RegisteredUserEntity;
import com.api.repository.RegisteredUserRepository;
import com.api.token.ConfirmationToken;
import com.api.token.ConfirmationTokenService;

@Service
public class RegisteredUserService {
	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private EmailValidator emailValidator;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	private EmailSender emailSender;
		
	public String createUser(RegisteredUserDTO data) {
		boolean isValidEmail = emailValidator.test(data.getEmail());
		if(!isValidEmail) {
			throw new IllegalStateException("Email Not Valid");
		}
		String token = customUserDetailService.signUpUser(new RegisteredUserDTO(
				data.getUserName(),
				data.getName(),
				data.getPassword(),
				data.getEmail(),
				AppUserRole.ROLE_USER
				));
		
		String link = "http://localhost:8400/api/v1/register/confirm?token=" + token;
        emailSender.send(
        		data.getEmail(),
                buildEmail(data.getName(), link));
		return token;
	}

	public RegisteredUserDTO getUser(String userName) {
		Optional<RegisteredUserEntity> value =	registeredUserRepository.findById(userName);
		RegisteredUserEntity detail = value.get();
		return  RegisteredUserEntity.prepareDTO(detail);
	}

	@Transactional
	public String confirmToken(String token) {
		ConfirmationToken confirmationToken = confirmationTokenService
				                              .getToken(token)
				                              .orElseThrow(() -> new IllegalStateException("Token Not Found"));
		if(confirmationToken.getConfirmedAt() !=null) {
			throw new IllegalStateException("Email Already Confirmed");
		}
		LocalDateTime expiredAt = confirmationToken.getExpiresAt();
		
		if(expiredAt.isBefore(LocalDateTime.now())) {
			throw new IllegalStateException("Token Expired");
		}
		confirmationTokenService.setConfirmedAt(token);
		customUserDetailService.enableAppUser(confirmationToken.getRegisteredUserEntity().getEmail());
		return "Confirmed";
	}
	
	
	private String buildEmail(String name, String link) {
        return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" +
                "\n" +
                "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" +
                "\n" +
                "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" +
                "        \n" +
                "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n" +
                "          <tbody><tr>\n" +
                "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n" +
                "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td style=\"padding-left:10px\">\n" +
                "                  \n" +
                "                    </td>\n" +
                "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n" +
                "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "              </a>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n" +
                "      <td>\n" +
                "        \n" +
                "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n" +
                "                  <tbody><tr>\n" +
                "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n" +
                "                  </tr>\n" +
                "                </tbody></table>\n" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" +
                "    </tr>\n" +
                "  </tbody></table>\n" +
                "\n" +
                "\n" +
                "\n" +
                "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n" +
                "    <tbody><tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n" +
                "        \n" +
                "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name + ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\"" + link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>" +
                "        \n" +
                "      </td>\n" +
                "      <td width=\"10\" valign=\"middle\"><br></td>\n" +
                "    </tr>\n" +
                "    <tr>\n" +
                "      <td height=\"30\"><br></td>\n" +
                "    </tr>\n" +
                "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" +
                "\n" +
                "</div></div>";
    }
}
