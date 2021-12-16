package com.api.token;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import com.api.entity.RegisteredUserEntity;

@Entity
public class ConfirmationToken {
	
	@SequenceGenerator(
			name= "confirmation_token_sequence",
			sequenceName = "confirmation_token_sequence",
			allocationSize = 1
			)
	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "confirmation_token_sequence"
			)
	private Long id;
	
	@Column(nullable = false)
	private String token;
	
	@Column(nullable = false)
	private LocalDateTime createdAt;
	
	@Column(nullable = false)
	private LocalDateTime expiresAt;
	
	private LocalDateTime confirmedAt;
	
	@ManyToOne
	@JoinColumn(
			nullable = false,
			name = "app_user_id"
			)
	private RegisteredUserEntity registeredUserEntity;
	
	public ConfirmationToken() {}

	public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt,
			RegisteredUserEntity registeredUserEntity) {
		super();
		this.token = token;
		this.createdAt = createdAt;
		this.expiresAt = expiresAt;
		this.registeredUserEntity = registeredUserEntity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(LocalDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public LocalDateTime getConfirmedAt() {
		return confirmedAt;
	}

	public void setConfirmedAt(LocalDateTime confirmedAt) {
		this.confirmedAt = confirmedAt;
	}

	public RegisteredUserEntity getRegisteredUserEntity() {
		return registeredUserEntity;
	}

	public void setRegisteredUserEntity(RegisteredUserEntity registeredUserEntity) {
		this.registeredUserEntity = registeredUserEntity;
	}

	@Override
	public String toString() {
		return "ConfirmationToken [id=" + id + ", token=" + token + ", createdAt=" + createdAt + ", expiresAt="
				+ expiresAt + ", confirmedAt=" + confirmedAt + ", registeredUserEntity=" + registeredUserEntity + "]";
	}


}
