package br.com.agro.msagro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.dto.CidadeDTO;
import br.com.agro.msagro.util.UtilString;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_cidades")
public class Cidade extends Entidade {

	private static final long serialVersionUID = -3143036515124337704L;

	@Column(name = "nm_cidade", length = 100)
	private String nome;

	@Column(name = "cod_ibge", length = 20)
	private String codigoIbge;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id")
	private Estado estado;

	public String getCidadeFormatada() {
		try {
			return this.getNome() + "-" + this.getEstado().getSigla();
		} catch (Exception e) {
		}
		return UtilString.empty();
	}
	
	public CidadeDTO toDTO() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<CidadeDTO>() {});
	}
	
}
