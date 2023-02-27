package br.com.agro.msagro.util;

import java.text.ParseException;
import java.util.Formatter;

import javax.swing.text.MaskFormatter;

public class UtilFormatter {

	private static final String MASK_CPF = "###.###.###-##";

	private static final String MASK_CNPJ = "##.###.###/####-##";

	public static String formatarCpf(String cpf) {
		try {
			if (UtilString.isNotEmptyNull(cpf)) {
				cpf = UtilString.removerCaracteres(cpf);
				MaskFormatter mf = new MaskFormatter(MASK_CPF);
				mf.setValueContainsLiteralCharacters(false);
				return mf.valueToString(cpf);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return UtilString.empty();
	}

	public static String formatarCnpj(String cnpj) {
		try {
			if (UtilString.isNotEmptyNull(cnpj)) {
				cnpj = UtilString.removerCaracteres(cnpj);
				MaskFormatter mf = new MaskFormatter(MASK_CNPJ);
				mf.setValueContainsLiteralCharacters(false);
				return mf.valueToString(cnpj);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return UtilString.empty();
	}

	public static String somenteNumerosCnpj(String cnpj) {
		return UtilString.removerCaracteres(cnpj);
	}

	public static String formatarCpfCnpj(String valor) {
		if (UtilString.isNotEmptyNull(valor)) {
			if (valor.length() == 11) {
				return UtilFormatter.formatarCpf(valor);
			}
			return UtilFormatter.formatarCnpj(valor);
		}
		return UtilString.empty();
	}

	public static String formatar(String valor, String formato) {
		Formatter f = new Formatter();
		String retorno = f.format(formato, valor).toString();
		f.close();
		return retorno;
	}
}
