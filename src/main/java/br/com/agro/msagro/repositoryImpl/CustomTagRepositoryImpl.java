package br.com.agro.msagro.repositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.agro.msagro.repository.CustomTagRepository;
import lombok.Getter;

public class CustomTagRepositoryImpl implements CustomTagRepository{

	@Getter
	@PersistenceContext
	private EntityManager entityManager;
	
	
	 
}
