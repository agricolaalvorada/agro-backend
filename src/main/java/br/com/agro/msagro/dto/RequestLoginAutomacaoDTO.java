package br.com.agro.msagro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestLoginAutomacaoDTO {

	private String password;
	private String usernameOrEmail;
	
	
}
