package br.com.agro.msagro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CidadeDTO extends EntidadeAmbienteDTO{

	private String nome;

	private String codigoIbge;
	
	private EstadoDTO estadoDTO;
	
	public CidadeDTO toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<CidadeDTO>() {});
	}
	
}
