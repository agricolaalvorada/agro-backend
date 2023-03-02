package br.com.agro.msagro.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterParceiro {

    private String nome;
    private String fazenda;
    private String inscricaoEstadual;
    private String codigo;
    private String tipoPessoa;

}
