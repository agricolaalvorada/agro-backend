package br.com.agro.msagro.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.agro.msagro.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	
	@Value("${portal.jwt.expiration}")
	private String expiration;
	
	@Value("${portal.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication auth) {
		Usuario logado = (Usuario) auth.getPrincipal();
		Date hoje = new Date();
		Date dataExpira = new Date(hoje.getTime() + Long.parseLong(expiration)); 
		return Jwts.builder().setIssuer("portalagro")
				.setSubject(logado.getLogin())
				.setIssuedAt(hoje)
				.setExpiration(dataExpira)
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public boolean validaToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	public String getLoginUsuario(String token) {
		Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return body.getSubject();
	}
}
