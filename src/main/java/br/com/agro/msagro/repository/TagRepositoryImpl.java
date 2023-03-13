package br.com.agro.msagro.repository;

import br.com.agro.msagro.entity.Tag;
import br.com.agro.msagro.filter.FilterConsulta;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TagRepositoryImpl extends RepositoryUtils implements TagCustomRepository {

    @Override
    public FilterConsulta consultarTagsPaginada(FilterConsulta filterConsulta) {
        int first = (filterConsulta.getPagina() == 1 ? 0 : ((filterConsulta.getPagina() - 1) * filterConsulta.getRowsPorPagina()));
        CriteriaQuery<Tag> query = entityManager.getCriteriaBuilder().createQuery(Tag.class);
        Root<Tag> rootEntidade = query.from(Tag.class);
        List<Predicate> condicoes = aplicarFiltro(rootEntidade, filterConsulta.getFiltros());
        query.select(rootEntidade).where(condicoes.toArray(Predicate[]::new)).orderBy(aplicarOrdenacao(rootEntidade, filterConsulta.getOrdernacao()));
        filterConsulta.setTotalRegistros(recuperarCount(Tag.class, filterConsulta.getFiltros()));
        List<Tag> lista = entityManager.createQuery(query).setFirstResult(first).setMaxResults(filterConsulta.getRowsPorPagina()).getResultList();
        filterConsulta.setData(lista);
        return filterConsulta;
    }
}
