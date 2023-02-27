package br.com.agro.msagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agro.msagro.dto.TagDTO;
import br.com.agro.msagro.service.TagService;

@RestController
@RequestMapping(value = "/privado/tag")
public class TagController {

	private @Autowired TagService tagService;

	@GetMapping(value = "/obterTodos")
	public ResponseEntity<Iterable<TagDTO>> consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(tagService.findAll());
	}

	@PostMapping(value = "/salvar")
	public ResponseEntity<TagDTO> salvar(@RequestBody TagDTO tagDTO) {
		return ResponseEntity.status(HttpStatus.OK).body(tagService.save(tagDTO));
	}
	
}
