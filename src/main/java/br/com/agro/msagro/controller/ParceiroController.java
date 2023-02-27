package br.com.agro.msagro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.agro.msagro.dto.ParceiroDTO;
import br.com.agro.msagro.service.ParceiroService;

@RestController
@RequestMapping(value = "/privado/parceiro")
public class ParceiroController {

	@Autowired private ParceiroService parceiroService;
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<Page<ParceiroDTO>> findAll(Pageable pageable) {
		return ResponseEntity.ok(parceiroService.findAll(pageable));
	}
	
	@GetMapping(value = "/findByNome")
	public ResponseEntity<List<ParceiroDTO>> findByNome(@RequestParam String nome) {
		return ResponseEntity.ok(parceiroService.findByNome(nome));
	}
	
	
	
}
