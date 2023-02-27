package br.com.agro.msagro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agro.msagro.dto.DestinoCargaDescargaDTO;
import br.com.agro.msagro.entity.DestinoCargaDescarga;
import br.com.agro.msagro.service.DestinoCargaDescargaService;

@RestController
@RequestMapping(value = "/privado/destino-carga-descarga")
public class DestinoCargaDescargaController {

	private @Autowired DestinoCargaDescargaService destinoService;

	@GetMapping(value = "/obterTodos")
	public ResponseEntity<Iterable<DestinoCargaDescargaDTO>> consultarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(destinoService.findAll());
	}
	@PostMapping(value = "/salvar")
	public ResponseEntity<DestinoCargaDescarga> salvar(@RequestBody DestinoCargaDescargaDTO destinoCargaDescarga) {
		return ResponseEntity.status(HttpStatus.OK).body(destinoService.save(destinoCargaDescarga));
	}

}
