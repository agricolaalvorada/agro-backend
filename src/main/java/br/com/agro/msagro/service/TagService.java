package br.com.agro.msagro.service;

import br.com.agro.msagro.dto.TagDTO;
import br.com.agro.msagro.entity.Tag;
import br.com.agro.msagro.feignclient.AutomacaoClientWS;
import br.com.agro.msagro.filter.FilterConsulta;
import br.com.agro.msagro.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

	private @Autowired TagRepository tagRepository;
	private @Autowired AutomacaoClientWS automacaoClientWS;
	
	public FilterConsulta consultaPaginada(FilterConsulta filterConsulta) {
		tagRepository.consultarTagsPaginada(filterConsulta);
		List<Tag> lstTag = (List<Tag>) new ArrayList<>(filterConsulta.getData());
		List<TagDTO> lstDTO = lstTag.stream().map(Tag::toDTO).collect(Collectors.toList());
		filterConsulta.setData(lstDTO);
		return filterConsulta;
	}
	public TagDTO save(TagDTO tagDTO) {
		//salvar a tag
		Tag tag = tagDTO.toEntity();
		tag = tagRepository.save(tag);
		//enviar para automacao
		automacaoClientWS.salvarTag(tag);
		return tag.toDTO();
	}
	
}
