package br.com.agro.msagro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.agro.msagro.entity.DestinoCargaDescarga;

@Repository
public interface DestinoCargaDescargaRepository extends CrudRepository<DestinoCargaDescarga, Long>{
	
}
