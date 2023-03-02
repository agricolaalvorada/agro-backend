package br.com.agro.msagro.controller;

import java.util.HashMap;
import java.util.List;

import br.com.agro.msagro.filter.FilterParceiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.agro.msagro.dto.ParceiroDTO;
import br.com.agro.msagro.service.ParceiroService;

@RestController
@RequestMapping(value = "/privado/parceiro")
public class ParceiroController {

	@Autowired private ParceiroService parceiroService;
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<Page<ParceiroDTO>> findAll(Pageable pageable, @RequestBody FilterParceiro filter) {
		return ResponseEntity.ok(parceiroService.findAll(pageable, filter));
	}
	
	@GetMapping(value = "/findByNome")
	public ResponseEntity<List<ParceiroDTO>> findByNome(@RequestParam String nome) {
		return ResponseEntity.ok(parceiroService.findByNome(nome));
	}
	
	
	
}
