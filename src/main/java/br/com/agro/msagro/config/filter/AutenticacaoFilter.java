package br.com.agro.msagro.config.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.agro.msagro.entity.Usuario;
import br.com.agro.msagro.repository.UsuarioRepository;
import br.com.agro.msagro.service.TokenService;


public class AutenticacaoFilter extends OncePerRequestFilter{

	private TokenService tokenService;
	private UsuarioRepository usuarioRepository;
	
	public AutenticacaoFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = recuperaToken(request);
		
		boolean tokenValido = tokenService.validaToken(token);
		
		if(tokenValido) {
			autenticarCliente(token);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String recuperaToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) return null;
		
		return token.substring(7, token.length());
	}
	
	
	private void autenticarCliente(String token) {
		String login = tokenService.getLoginUsuario(token);
		Optional<Usuario> usuario = usuarioRepository.findByLogin(login);
		if(usuario.isPresent()) {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(usuario.get(), token, usuario.get().getAuthorities()); 
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
	}
}
