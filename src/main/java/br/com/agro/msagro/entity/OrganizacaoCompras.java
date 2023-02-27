package br.com.agro.msagro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.dto.OrganizacaoComprasDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_organizacao_compras")
public class OrganizacaoCompras extends EntidadeAmbiente {

	private static final long serialVersionUID = 1L;

	@Column(name = "nome")
	private String nome;

	@Column(name = "codigo")
	private String codigo;

	public OrganizacaoComprasDTO toDTO() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<OrganizacaoComprasDTO>() {});
	}
	
}
