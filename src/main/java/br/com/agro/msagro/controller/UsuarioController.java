package br.com.agro.msagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agro.msagro.dto.UsuarioDTO;
import br.com.agro.msagro.service.UsuarioService;

@RestController
@RequestMapping("/privado/usuario")
public class UsuarioController {

	@Autowired private UsuarioService usuarioService;
	
	@GetMapping(value = "/findByLogin")
	public ResponseEntity<UsuarioDTO> findByLogin(@RequestParam String login) {
		UsuarioDTO user = usuarioService.findByLogin(login);
		
		if(user != null)
			try {
				return ResponseEntity.ok(user);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		return ResponseEntity.notFound().build();
	}
	
}
