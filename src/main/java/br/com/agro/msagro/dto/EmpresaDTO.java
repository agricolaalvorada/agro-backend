package br.com.agro.msagro.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.entity.Empresa;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmpresaDTO extends EntidadeAmbienteDTO{

	private String nome;

	private String codigo;

	
	public Empresa toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<Empresa>() {});
	}
	
}
