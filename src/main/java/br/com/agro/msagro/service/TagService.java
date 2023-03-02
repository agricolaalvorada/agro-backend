package br.com.agro.msagro.service;

import java.util.ArrayList;
import java.util.List;

import br.com.agro.msagro.dto.ParceiroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.agro.msagro.dto.TagDTO;
import br.com.agro.msagro.entity.Tag;
import br.com.agro.msagro.feignclient.AutomacaoClientWS;
import br.com.agro.msagro.repository.TagRepository;

@Service
public class TagService {

	private @Autowired TagRepository tagRepository;
	private @Autowired AutomacaoClientWS automacaoClientWS;
	
	public Page<TagDTO> findAll(Pageable page) {
		return tagRepository.findAll(page).map(Tag::toDTO);
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
