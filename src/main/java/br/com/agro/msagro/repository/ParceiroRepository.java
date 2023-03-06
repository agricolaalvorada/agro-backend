package br.com.agro.msagro.repository;

import java.util.List;

import br.com.agro.msagro.dto.ParceiroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.agro.msagro.entity.Parceiro;

@Repository
public interface ParceiroRepository extends PagingAndSortingRepository<Parceiro, Long>, ParceiroCustomRepository {

}
