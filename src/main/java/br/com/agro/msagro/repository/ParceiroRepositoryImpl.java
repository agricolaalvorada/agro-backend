package br.com.agro.msagro.repository;

import br.com.agro.msagro.entity.Parceiro;
import br.com.agro.msagro.filter.FilterConsulta;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ParceiroRepositoryImpl extends RepositoryUtils implements ParceiroCustomRepository {
    @Override
    public FilterConsulta consultarParceiroPaginada(FilterConsulta filterConsulta) {
        int first = (filterConsulta.getPagina() == 1 ? 0 : ((filterConsulta.getPagina() - 1) * filterConsulta.getRowsPorPagina()));
        CriteriaQuery<Parceiro> query = entityManager.getCriteriaBuilder().createQuery(Parceiro.class);
        Root<Parceiro> rootEntidade = query.from(Parceiro.class);
        List<Predicate> condicoes = aplicarFiltro(rootEntidade, filterConsulta.getFiltros());
        query.select(rootEntidade).where(condicoes.toArray(Predicate[]::new)).orderBy(aplicarOrdenacao(rootEntidade, filterConsulta.getOrdernacao()));
        filterConsulta.setTotalRegistros(recuperarCount(Parceiro.class, filterConsulta.getFiltros()));
        List<Parceiro> lista = entityManager.createQuery(query).setFirstResult(first).setMaxResults(filterConsulta.getRowsPorPagina()).getResultList();
        filterConsulta.setData(lista);
        return filterConsulta;
    }
}
