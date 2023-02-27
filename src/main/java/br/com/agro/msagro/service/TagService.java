package br.com.agro.msagro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agro.msagro.dto.TagDTO;
import br.com.agro.msagro.entity.Tag;
import br.com.agro.msagro.feignclient.AutomacaoClientWS;
import br.com.agro.msagro.repository.TagRepository;

@Service
public class TagService {

	private @Autowired TagRepository tagRepository;
	private @Autowired AutomacaoClientWS automacaoClientWS;
	
	public Iterable<TagDTO> findAll() {
		Iterable<Tag> list = tagRepository.findAll();
		List<TagDTO> listDTO = new ArrayList<>();
		list.iterator().forEachRemaining(t -> listDTO.add(t.toDTO()));
		return listDTO;
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
