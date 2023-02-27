package br.com.agro.msagro.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilSecurity {

	private static MessageDigest digester;

	private static final String[] CARACTERES = { "a", "1", "b", "2", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y",
			"z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
			"U", "V", "W", "X", "Y", "Z" };

	static {
		try {
			UtilSecurity.digester = MessageDigest.getInstance("MD5");
		} catch (final NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static String cript(final String str) {

		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}

		UtilSecurity.digester.update(str.getBytes());
		final byte[] hash = UtilSecurity.digester.digest();
		final StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			if ((0xff & hash[i]) < 0x10) {
				hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
			} else {
				hexString.append(Integer.toHexString(0xFF & hash[i]));
			}
		}
		return hexString.toString();
	}

	public static String gerarNovaSenha() {
		int qtdeMaximaCaracteres = 8;
		String[] caracteres = CARACTERES;
		StringBuilder senha = new StringBuilder();
		for (int i = 0; i < qtdeMaximaCaracteres; i++) {
			int posicao = (int) (Math.random() * caracteres.length);
			senha.append(caracteres[posicao]);
		}
		return senha.toString();
	}

	public static String cript(final String textoBase, final String tipo) {
		StringBuilder hexString = new StringBuilder();
		try {
			MessageDigest algorithm;
			algorithm = MessageDigest.getInstance(tipo);
			byte messageDigest[] = algorithm.digest(textoBase.getBytes("UTF-8"));
			for (byte b : messageDigest) {
				hexString.append(String.format("%02X", 0xFF & b));
			}
		} catch (Exception e) {
			hexString.append("Tipo de criptografia não encontrado!");
			e.printStackTrace();
		}
		return hexString.toString();
	}
}
