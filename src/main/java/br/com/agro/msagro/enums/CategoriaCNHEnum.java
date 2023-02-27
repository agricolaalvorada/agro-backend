package br.com.agro.msagro.enums;

import java.util.Arrays;

import br.com.agro.msagro.util.UtilString;
import lombok.Getter;
import lombok.Setter;

public enum CategoriaCNHEnum {

	A("A"), B("B"), C("C"), D("D"), E("E"), AB("AB"), AC("AC"), AD("AD"), AE("AE"), ACC("ACC"),
	MOTOR_CASA("MOTOR-CASA");

	@Getter
	@Setter
	private String descricao;

	CategoriaCNHEnum(String descricao) {
		this.setDescricao(descricao);
	}

	public static CategoriaCNHEnum obter(String desc) {
		try {
			if (UtilString.isNotEmptyNull(desc)) {
				return Arrays.asList(CategoriaCNHEnum.values()).stream().filter(a -> a.getDescricao().equals(desc))
						.findFirst().get();
			}
		} catch (Exception e) {
		}
		return null;
	}
}
