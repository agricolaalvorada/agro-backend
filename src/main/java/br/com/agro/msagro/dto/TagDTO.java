package br.com.agro.msagro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.entity.Tag;
import br.com.agro.msagro.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TagDTO extends EntidadeAmbienteDTO{
	
	private String codigo;
	private String numero;
	private StatusEnum status;
	private boolean carregamento;
	
	public Tag toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<Tag>() {});
	}
}
