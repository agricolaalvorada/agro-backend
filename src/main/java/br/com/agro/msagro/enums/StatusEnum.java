package br.com.agro.msagro.enums;

import java.util.Arrays;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

public enum StatusEnum {

	ATIVO("Ativo"),

	INATIVO("Inativo"),

	TEMPORARIO("Temporário"),

	BLOQUEADO("Bloqueado"),
	
	INCOMPLETO("Incompleto"),
	
	ELIMINADO("ELIMINADO");

	@Getter
	@Setter
	private String descricao;

	private StatusEnum( final String descricao ) {

		this.descricao = descricao;
	}

	public static Collection<StatusEnum> valuesAtivoInativo() {

		return Arrays.asList(new StatusEnum[] { StatusEnum.ATIVO, StatusEnum.INATIVO });
	}
	
	public static Collection<StatusEnum> valuesStatusVeiculo() {
		
		return Arrays.asList(new StatusEnum[] { StatusEnum.ATIVO, StatusEnum.INATIVO, StatusEnum.INCOMPLETO });
	}
}
