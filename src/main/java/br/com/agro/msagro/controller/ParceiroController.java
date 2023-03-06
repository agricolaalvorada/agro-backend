package br.com.agro.msagro.controller;

import br.com.agro.msagro.filter.FilterConsulta;
import br.com.agro.msagro.service.ParceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/privado/parceiro")
public class ParceiroController {

	@Autowired private ParceiroService parceiroService;
	
	@PostMapping(value = "/findAll")
	public ResponseEntity<FilterConsulta> findAll(@RequestBody FilterConsulta filter) {
		return ResponseEntity.ok().body(parceiroService.findAll(filter));
	}

}
