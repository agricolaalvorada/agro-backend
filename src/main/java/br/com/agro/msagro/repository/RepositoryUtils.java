package br.com.agro.msagro.repository;

import br.com.agro.msagro.util.UtilObjeto;
import br.com.agro.msagro.util.UtilString;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;

public class RepositoryUtils {

    @PersistenceContext
    EntityManager entityManager;

    public List<Predicate> aplicarFiltro(Root<?> rootEntidade, Map<String, Object> filtros) {
        List<Predicate> listaPredicate = new ArrayList<Predicate>();
        if(filtros == null) return Collections.emptyList();
        for (final String chave : filtros.keySet()) {
            Object value = filtros.get(chave);
            if(value == null || UtilString.isEmpty(value.toString())) continue;
            if (UtilObjeto.isNotNull(filtros.get(chave)) && !(filtros.get(chave).toString().isEmpty())) {
                if(chave.contains(".")){
                    String atributo = chave.replace(".", "#");
                    String[] campos = atributo.split("#");
                    Path path = null;
                    if(rootEntidade.get(campos[0]).getJavaType().isAssignableFrom(Collection.class)){
                        Join joinAnother = rootEntidade.join(campos[0], JoinType.INNER);
                        path = joinAnother.get(campos[1]);
                    }else{
                        path = rootEntidade.get(campos[0]);
                        for(int i = 1; (i + 1) <= campos.length; i++){
                            path = path.get(campos[i]);
                        }
                    }

                    if(path.getJavaType().isEnum()){
                        listaPredicate.add(getCriteriaBuilder().equal(path.as(String.class), value));

                    }else if (value instanceof String) {
                        listaPredicate.add(getCriteriaBuilder().like(getCriteriaBuilder().upper(path), "%" + value.toString().toUpperCase() + "%"));

                    } else {
                        listaPredicate.add(getCriteriaBuilder().or(getCriteriaBuilder().equal(path, value), getCriteriaBuilder().isNull(path)));
                    }
                }else if(chave.contains(":")){
                    String[] campos = chave.split(":");
                    List<Predicate> predsOr = new ArrayList<>();
                    for(String str : campos){
                        if(UtilString.isNumerico(value.toString())){
                            predsOr.add(getCriteriaBuilder().equal(rootEntidade.get(str), value));
                        }else{
                            predsOr.add(getCriteriaBuilder().like(getCriteriaBuilder().upper(rootEntidade.get(str)), "%" + value.toString().toUpperCase() + "%"));
                        }
                    }
                    listaPredicate.add(getCriteriaBuilder().or(predsOr.toArray(new Predicate[0])));
                }else{
                    if(rootEntidade.get(chave).getJavaType().isEnum()){
                        listaPredicate.add(getCriteriaBuilder().equal(rootEntidade.get(chave).as(String.class), value));

                    }else if (value instanceof String) {
                        listaPredicate.add(getCriteriaBuilder().like(getCriteriaBuilder().upper(rootEntidade.get(chave)), "%" + value.toString().toUpperCase() + "%"));

                    } else {
                        listaPredicate.add(getCriteriaBuilder().or(getCriteriaBuilder().equal(rootEntidade.get(chave), value), getCriteriaBuilder().isNull(rootEntidade.get(chave))));
                    }
                }

            }
        }

        return listaPredicate;
    }


    public List<Order> aplicarOrdenacao(Root<?> root, Map<String, String> ordenacao) {
        List<Order> orders = new ArrayList<>(List.of());
        for (String chave : ordenacao.keySet()) {
            String tpSort = ordenacao.get(chave);
            if (!StringUtils.isEmpty(chave)) {
                if (tpSort.equals("ASC")) {
                    orders.add(getCriteriaBuilder().asc(root.get(chave)));
                } else {
                    orders.add(getCriteriaBuilder().desc(root.get(chave)));
                }
            }
        }
        return orders;
    }

    public int recuperarCount(Class<?> entidade, Map<String, Object> filtros) {
        CriteriaQuery<Long> query = getCriteriaBuilder().createQuery(Long.class);
        Root<?> rootEntidade = query.from(entidade);
        List<Predicate> condicoes = aplicarFiltro(rootEntidade, filtros);
        query.select(getCriteriaBuilder().count(rootEntidade)).where(condicoes.toArray(Predicate[]::new));
        return entityManager.createQuery(query).getSingleResult().intValue();
    }

    private CriteriaBuilder getCriteriaBuilder() {
        return entityManager.getCriteriaBuilder();
    }

}
