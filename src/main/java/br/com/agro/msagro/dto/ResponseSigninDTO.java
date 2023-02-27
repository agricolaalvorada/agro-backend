package br.com.agro.msagro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSigninDTO {
	
	private Long id;
	private String token;
	
	
}
