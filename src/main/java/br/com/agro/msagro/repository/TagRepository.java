package br.com.agro.msagro.repository;

import br.com.agro.msagro.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>, CustomTagRepository{
	
}
