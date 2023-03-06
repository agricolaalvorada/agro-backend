package br.com.agro.msagro.repository;

import br.com.agro.msagro.filter.FilterConsulta;

public interface TagCustomRepository {

    FilterConsulta consultarTagsPaginada(FilterConsulta filterConsulta);

}
