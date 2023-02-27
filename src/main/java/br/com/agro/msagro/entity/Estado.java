package br.com.agro.msagro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.dto.EstadoDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_estados")
public class Estado extends Entidade {

	private static final long serialVersionUID = -540220550923963515L;

	@Column(name = "ds_sigla", length = 3)
	private String sigla;

	public EstadoDTO toDTO() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<EstadoDTO>() {});
	}

}
