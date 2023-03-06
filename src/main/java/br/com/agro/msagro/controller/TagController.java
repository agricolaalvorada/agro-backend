package br.com.agro.msagro.controller;

import br.com.agro.msagro.dto.TagDTO;
import br.com.agro.msagro.filter.FilterConsulta;
import br.com.agro.msagro.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/privado/tag")
public class TagController {

	private @Autowired TagService tagService;

	@PostMapping(value = "/findAll")
	public ResponseEntity<FilterConsulta> consultarTodos(@RequestBody FilterConsulta filter) {
		return ResponseEntity.ok().body(tagService.consultaPaginada(filter));
	}

	@PostMapping(value = "/salvar")
	public ResponseEntity<TagDTO> salvar(@RequestBody TagDTO tagDTO) {
		return ResponseEntity.ok(tagService.save(tagDTO));
	}
	
}
