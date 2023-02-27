package br.com.agro.msagro.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;

public final class UtilString {

	private static final EqualsBuilder equalsBuilder;
	private static final int LIMITE_CHARACTER_SAP = 200;

	static {
		equalsBuilder = new EqualsBuilder();
	}

	private UtilString() {
		super();
	}

	public static boolean isEmpty(final String string) {
		return StringUtils.isBlank(string);
	}

	public static boolean isEmptyNull(final String string) {
		return UtilString.isEmpty(string) || UtilString.isEquals(string, "null");
	}

	public static boolean isNotEmptyNull(final String string) {
		return !UtilString.isEmptyNull(string);
	}

	public static boolean isEmpty(final String... strings) {
		if (UtilObjeto.isNull((Object[]) strings)) {
			return Boolean.TRUE;
		}
		for (final String string : strings) {
			if (UtilString.isEmpty(string)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public static boolean isEquals(final String principal, final String texto) {
		final boolean isEquals = UtilString.equalsBuilder.append(principal.trim(), texto.trim()).isEquals();
		UtilString.equalsBuilder.reset();
		return isEquals;
	}

	public static String maiuscula(final String string) {
		String strMaiuscula = string;
		if (!UtilString.isEmpty(string)) {
			strMaiuscula = string.toUpperCase();
		}
		return strMaiuscula;
	}

	public static String minuscula(final String string) {
		String strMinuscula = string;
		if (!UtilString.isEmpty(string)) {
			strMinuscula = string.toLowerCase();
		}
		return strMinuscula;
	}

	public static List<String> split(final String string, final String delimitador) {
		final List<String> result = new ArrayList<>();
		if (!UtilString.isEmpty(string, delimitador)) {
			final StringTokenizer st = new StringTokenizer(string, delimitador);
			while (st.hasMoreTokens()) {
				result.add(st.nextToken());
			}
		}
		return result;
	}
	
	public static String removerAcentuacao(final String string) {
		String result = string;
		if (!UtilString.isEmpty(string)) {
			result = UtilString.substituir(result, "[ÁÀÂÃ]", "A");
			result = UtilString.substituir(result, "[áàâãª]", "a");
			result = UtilString.substituir(result, "[ÉÈÊ]", "E");
			result = UtilString.substituir(result, "[éèê]", "e");
			result = UtilString.substituir(result, "[ÍÌÎÏ]", "I");
			result = UtilString.substituir(result, "[íìîï]", "i");
			result = UtilString.substituir(result, "[ÓÒÔÕÖ]", "O");
			result = UtilString.substituir(result, "[óòôõºö]", "o");
			result = UtilString.substituir(result, "[ÚÙÛÜ]", "U");
			result = UtilString.substituir(result, "[úùûü]", "u");
			result = UtilString.substituir(result, "[Ç]", "C");
			result = UtilString.substituir(result, "[ç]", "c");
			result = UtilString.substituir(result, "[~\\d^Ž`]", "");
			result = UtilString.substituir(result, "[\\dš]", "");
		}
		return result;
	}

	public static String removerCaracteres(final String string) {
		String result = string;
		if (!UtilString.isEmpty(string)) {
			result = UtilString.remover(string, "[^0-9]");
		}
		return result;
	}

	public static String remover(final String srcString, final String localizar) {
		String result = srcString;
		if (!UtilString.isEmpty(srcString, localizar)) {
			result = srcString.replaceAll(localizar, "");
		}
		return result;
	}

	public static String substituir(final String srcString, final String localizar, final String novaString) {
		String result = srcString;
		if (!UtilString.isEmpty(srcString, localizar)) {
			result = srcString.replaceAll(localizar, novaString);
		}
		return result;
	}

	public static String substituirSe(final boolean condicao, final String srcString, final String localizar,
			final String seVerdadeiro, final String seFalso) {
		String result = srcString;
		if (condicao) {
			result = UtilString.substituir(srcString, localizar, seVerdadeiro);
		} else {
			result = UtilString.substituir(srcString, localizar, seFalso);
		}
		return result;
	}

	public static int getTamanho(final String string) {
		return !UtilString.isEmpty(string) ? string.length() : 0;
	}

	public static String empty() {
		return StringUtils.EMPTY;
	}

	public static String newLine() {
		return "\n";
	}

	public static boolean soContemNumero(final String valor) {
		final char[] dados = valor.toCharArray();
		for (final char item : dados) {
			if (!Character.isDigit(item)) {
				return false;
			}
		}
		return true;
	}

	public static String log(final String texto) {
		return MessageFormat.format("\n\n********\n\n{0}\n\n********\n", texto);
	}

	public static String completarZeroAEsquerda(int completar, String valor) {
		if (UtilString.isNotEmptyNull(valor)) {
			int size = valor.length();
			int total = completar - size;
			String zero = "";
			for (int i = 0; i < total; i++) {
				zero = zero + 0;
			}
			String ultima = zero + valor;
			return ultima;
		}
		return UtilString.empty();
	}

	public static String removerZerosAEsquerda(String valorOriginal) {
		if (UtilString.isNotEmptyNull(valorOriginal)) {
			return valorOriginal.replaceFirst("0*", "");
		}
		return UtilString.empty();
	}

	public static boolean isAlphaNumerico(String s) {
		String pattern = "^[a-zA-Z0-9]*$";
		return s.matches(pattern);
	}

	public static boolean isNumerico(String s) {
		String pattern = "^[0-9]*$";
		return s.trim().matches(pattern);
	}

	public static String concatenarStrings(final String str1, final String str2) {
		String result = "";
		if (!UtilString.isEmpty(str1)) {
			result = result + str1;
		}
		if (!UtilString.isEmpty(str1) && !UtilString.isEmpty(str2)) {
			result = result + " - ";
		}
		if (!UtilString.isEmpty(str2)) {
			result = result + str2;
		}
		return result;
	}

	public static List<String> converterStringFormatoSAP(String str) {
		List<String> result = new ArrayList<>();
		if (!UtilString.isEmpty(str)) {
			str = str.replaceAll("\r", " ");
			str = str.replaceAll("\t", " ");
			str = str.replaceAll("\n", " ");
			if (str.length() > LIMITE_CHARACTER_SAP) {
				result.add(str.substring(0, LIMITE_CHARACTER_SAP));
				result.addAll(converterStringFormatoSAP(str.substring(LIMITE_CHARACTER_SAP, str.length())));
			} else {
				result.add(str);
			}
		}
		return result;
	}

	public static String[] quebrarStringPorPorTamanho(String s, int size) {
		if (s == null || size <= 0) {
			return null;
		}
		int chunks = s.length() / size + ((s.length() % size > 0) ? 1 : 0);
		String[] arr = new String[chunks];
		for (int i = 0, j = 0, l = s.length(); i < l; i += size, j++) {
			arr[j] = s.substring(i, Math.min(l, i + size));
		}
		return arr;
	}

	public static String gerarHoraSegundosAtual() {
		Date date = UtilDate.hoje();
		String hora = UtilDate.format(date, "ddMMYYYYHHmmsss");
		UUID uuid = UUID.randomUUID();
		hora = hora + uuid.toString().substring(0, 5);
		return hora.trim();
	}

	public static String regex(String s, String regex) {
//		String pattern = regex;
		final Pattern STRING_PESO = Pattern.compile(regex);
		Matcher m = STRING_PESO.matcher(s);

		return m.group(1);

//		return s.trim().matches(pattern);
	}

	public static String trataNull(String obj) {
		if(obj == null){
			return "";
		}
		return obj.trim();
	}

	public static String preencheTextoComEspacos(int tamanho, String valor, String direcaoDireitaEsquerda) {
		if(valor == null)
			return "";

		if(valor.length() > tamanho)
			return valor.substring(0, tamanho);

		int size = valor.length();
		int total = tamanho - size;
		String completar = "";
		for (int i = 0; i < total; i++) {
			completar = completar + " ";
		}
		String ultima = "";
		if(direcaoDireitaEsquerda.equals("E"))
			 ultima = completar + valor;
		else
			ultima = valor + completar;

		return ultima;
	}

}
