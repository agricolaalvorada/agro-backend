package br.com.agro.msagro.service;

import br.com.agro.msagro.dto.ParceiroDTO;
import br.com.agro.msagro.entity.Parceiro;
import br.com.agro.msagro.filter.FilterParceiro;
import br.com.agro.msagro.repository.ParceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParceiroService {

	private @Autowired ParceiroRepository parceiroRepository;
	
	public Page<ParceiroDTO> findAll(Pageable page, FilterParceiro filter) {

		return parceiroRepository.findAllByNomeContainingOrFazendaContainingOrInscricaoEstadualContainingOrCodigoContainingOrTipoPessoaEquals(page,
				filter.getNome(), filter.getFazenda(), filter.getInscricaoEstadual(), filter.getCodigo(), filter.getTipoPessoa()
		).map(Parceiro::toDTO);
	}
	
	public List<ParceiroDTO> findByNome(String nome) {
		Iterable<Parceiro> list = parceiroRepository.findAll();
		List<ParceiroDTO> listDTO = new ArrayList<>();
		list.iterator().forEachRemaining(t -> listDTO.add(t.toDTO()));
		return listDTO;
	}
	
}
