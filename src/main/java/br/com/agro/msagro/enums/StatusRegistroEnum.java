package br.com.agro.msagro.enums;

import lombok.Getter;
import lombok.Setter;

public enum StatusRegistroEnum {

	ATIVO("Ativo"),

	INATIVO("Inativo"),

	BLOQUEADO("Bloqueado"),

	ELIMINADO("Eliminado"),

	BLOQUEADO_E_ELIMINADO("Bloqueado e Eliminado");

	@Getter
	@Setter
	private String descricao;

	private StatusRegistroEnum(String descricao) {
		this.setDescricao(descricao);
	}


}
