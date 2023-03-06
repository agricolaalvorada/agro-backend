package br.com.agro.msagro.service;

import br.com.agro.msagro.dto.ParceiroDTO;
import br.com.agro.msagro.dto.TagDTO;
import br.com.agro.msagro.entity.Parceiro;
import br.com.agro.msagro.filter.FilterConsulta;
import br.com.agro.msagro.repository.ParceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParceiroService {

	private @Autowired ParceiroRepository parceiroRepository;
	
	public FilterConsulta findAll(FilterConsulta filterConsulta) {
		parceiroRepository.consultarParceiroPaginada(filterConsulta);
		List<Parceiro> lstTag = (List<Parceiro>) new ArrayList<>(filterConsulta.getData());
		List<ParceiroDTO> lstDTO = lstTag.stream().map(Parceiro::toDTO).collect(Collectors.toList());
		filterConsulta.setData(lstDTO);
		return filterConsulta;
	}
	
}
