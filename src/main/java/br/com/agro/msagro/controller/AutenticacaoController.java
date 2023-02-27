package br.com.agro.msagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agro.msagro.dto.RequestLoginDTO;
import br.com.agro.msagro.dto.TokenDTO;
import br.com.agro.msagro.service.TokenService;


@RestController
@RequestMapping("/publico/auth")
public class AutenticacaoController {

	@Autowired private AuthenticationManager auteAuthenticationManager;
	@Autowired private TokenService tokenService;
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> autenticar(@RequestBody RequestLoginDTO requestLogin) {
		UsernamePasswordAuthenticationToken dadosLogin = requestLogin.toUsernamePassword();
		try {
			Authentication auth = auteAuthenticationManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(auth);
			return ResponseEntity.ok(new TokenDTO("Bearer", token));	
			
		}catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
