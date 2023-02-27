package br.com.agro.msagro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.agro.msagro.dto.ParceiroDTO;
import br.com.agro.msagro.entity.Parceiro;
import br.com.agro.msagro.repository.ParceiroRepository;

@Service
public class ParceiroService {

	private @Autowired ParceiroRepository parceiroRepository;
	
	public Page<ParceiroDTO> findAll(Pageable page) {
		return parceiroRepository.findAll(page).map(t -> t.toDTO());
	}
	
	public List<ParceiroDTO> findByNome(String nome) {
		Iterable<Parceiro> list = parceiroRepository.findAll();
		List<ParceiroDTO> listDTO = new ArrayList<>();
		list.iterator().forEachRemaining(t -> listDTO.add(t.toDTO()));
		return listDTO;
	}
	
}
