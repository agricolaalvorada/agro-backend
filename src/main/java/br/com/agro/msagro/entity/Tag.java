package br.com.agro.msagro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.dto.TagDTO;
import br.com.agro.msagro.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_tag")
public class Tag extends EntidadeAmbiente {

	private static final long serialVersionUID = -3351987708785118658L;

	@Column(name = "codigo", length = 10, unique = true)
	private String codigo;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 10)
	private StatusEnum status;
	
	@Column(name = "numero", length = 10)
	private String numero;
	
	@Column(name = "carregamento", nullable = false, columnDefinition = "bit default 0")
	private boolean carregamento;
	
	public TagDTO toDTO() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<TagDTO>() {});
	}

}
