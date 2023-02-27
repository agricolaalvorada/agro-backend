package br.com.agro.msagro.enums;

import lombok.Getter;
import lombok.Setter;

public enum TipoPessoaEnum {

	PF("Pessoa Física"),

	PJ("Pessoa Juridica");

	@Getter
	@Setter
	private String value;

	TipoPessoaEnum( final String value ) {

		this.value = value;
	}

}
