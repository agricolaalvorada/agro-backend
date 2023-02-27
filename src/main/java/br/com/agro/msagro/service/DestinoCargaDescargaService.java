package br.com.agro.msagro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agro.msagro.dto.DestinoCargaDescargaDTO;
import br.com.agro.msagro.entity.DestinoCargaDescarga;
import br.com.agro.msagro.repository.DestinoCargaDescargaRepository;

@Service
public class DestinoCargaDescargaService {

	private @Autowired DestinoCargaDescargaRepository destinoCargaDescargaRepository;
	
	public Iterable<DestinoCargaDescargaDTO> findAll() {
		Iterable<DestinoCargaDescarga> list = destinoCargaDescargaRepository.findAll();
		List<DestinoCargaDescargaDTO> listDTO = new ArrayList<>();
		list.iterator().forEachRemaining(t -> listDTO.add(t.toDTO()));
		return listDTO;
	}

	public DestinoCargaDescarga save(DestinoCargaDescargaDTO destinoCargaDescarga) {
		return destinoCargaDescargaRepository.save(destinoCargaDescarga.toEntity());
	}
	
}
