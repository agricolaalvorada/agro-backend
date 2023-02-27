package br.com.agro.msagro.enums;

import lombok.Getter;
import lombok.Setter;

public enum TipoSubcontratadoEnum {

	SUBCT_AGREGADO("Subcontratado Agregado", "ZAGR"),

	SUBCT_DIFERENCIADO("Subcontratado Diferenciado", "ZDIF"),

	SUBCT_NORMAL("Subcontratado Normal", "ZNOR");

	@Getter
	@Setter
	private String descricao;

	@Getter
	@Setter
	private String codigo;

	TipoSubcontratadoEnum( String descricao, String codigo ) {

		this.descricao = descricao;

		this.codigo = codigo;

	}

	
	public static TipoSubcontratadoEnum obterPorCodigo(String value) {

		for (TipoSubcontratadoEnum tipo : TipoSubcontratadoEnum.values()) {

			if (tipo.getCodigo().equals(value)) {

				return tipo;
			}
		}

		return null;
	}
}
