package br.com.agro.msagro.enums;

import lombok.Getter;
import lombok.Setter;

public enum StatusCadastroEnum {

	REGISTRO_ATUALIZADO("Cadastro alterado, apos sincronização"),

	SINCRONIZADO_COM_SUCESSO("Sincronizado com sucesso"),

	NAO_ENVIADO("Não enviado"),

	RETORNO_COM_ERRO("Retorno com erro"),

	ENVIADO("Enviado");

	@Getter
	@Setter
	private String descricao;

	private StatusCadastroEnum( final String descricao ) {

		this.descricao = descricao;
	}

}
