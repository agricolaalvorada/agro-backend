package br.com.agro.msagro.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Data;

@Data
public class RequestLoginDTO {

	private String username;
	private String password;
	
	public UsernamePasswordAuthenticationToken toUsernamePassword() {
		return new UsernamePasswordAuthenticationToken(username, password);
	}
	
}