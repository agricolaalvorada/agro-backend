package br.com.agro.msagro.dto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.entity.OrganizacaoCompras;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizacaoComprasDTO extends EntidadeAmbienteDTO{
	private String nome;

	private String codigo;
	
	public OrganizacaoCompras toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<OrganizacaoCompras>() {});
	}
}
