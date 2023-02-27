package br.com.agro.msagro.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.agro.msagro.entity.Parceiro;

@Repository
public interface ParceiroRepository extends PagingAndSortingRepository<Parceiro, Long> {
	
	List<Parceiro> findByNomeStartingWith(String nome);
	
}
