package br.com.agro.msagro.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterConsulta {

    private int pagina;
    private int rowsPorPagina;
    private List<?> data;
    private int totalRegistros;
    private HashMap<String, Object> filtros;
    private HashMap<String, String> ordernacao;

}
