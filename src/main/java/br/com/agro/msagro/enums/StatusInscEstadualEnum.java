package br.com.agro.msagro.enums;

import lombok.Getter;
import lombok.Setter;

public enum StatusInscEstadualEnum {

	ATIVO("Ativo"),

	INATIVO("Inativa"),

	ISENTO("Isento"),
	
	PENDENTE("Pendente");

	@Getter
	@Setter
	private String descricao;

	private StatusInscEstadualEnum( String descricao ) {

		this.descricao = descricao;
	}

}
