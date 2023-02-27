package br.com.agro.msagro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.entity.DestinoCargaDescarga;
import br.com.agro.msagro.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinoCargaDescargaDTO extends EntidadeAmbienteDTO{
	
    private String descricao;

    private StatusEnum status;
	
	public DestinoCargaDescarga toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<DestinoCargaDescarga>() {});
	}
}
