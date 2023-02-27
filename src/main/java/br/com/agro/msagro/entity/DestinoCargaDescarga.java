package br.com.agro.msagro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.dto.DestinoCargaDescargaDTO;
import br.com.agro.msagro.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_destino_carga_descarga")
public class DestinoCargaDescarga extends EntidadeAmbiente {
    
	private static final long serialVersionUID = 1L;

	@Column(name = "descricao")
    private String descricao;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
    private StatusEnum status;
	
	public DestinoCargaDescargaDTO toDTO() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<DestinoCargaDescargaDTO>() {});
	}
	
}
