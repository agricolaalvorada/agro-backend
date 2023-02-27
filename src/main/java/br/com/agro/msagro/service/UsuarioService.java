package br.com.agro.msagro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agro.msagro.dto.UsuarioDTO;
import br.com.agro.msagro.entity.Usuario;
import br.com.agro.msagro.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired private UsuarioRepository usuarioRepository;

	public UsuarioDTO findByLogin(String login) {
		Optional<Usuario> user = usuarioRepository.findByLogin(login);
		if(user.isPresent())
			return user.get().toDTO();
		return null;
	}

}
