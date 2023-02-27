package br.com.agro.msagro.enums;

import java.util.Arrays;

import br.com.agro.msagro.util.UtilString;

public enum TipoLocalidadeEnum {

	EXPORTACAO("EX"),

	BRASIL("BR");

	private String descricao;

	TipoLocalidadeEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoLocalidadeEnum obter(String desc) {
		try {
			if (UtilString.isNotEmptyNull(desc)) {
				return Arrays.asList(TipoLocalidadeEnum.values()).stream().filter(a -> a.getDescricao().equals(desc))
						.findFirst().get();
			}
		} catch (Exception e) {
		}
		return null;
	}

}
