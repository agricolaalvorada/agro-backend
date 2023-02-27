package br.com.agro.msagro.util;

import java.math.BigDecimal;

public class UtilBigDecimal {

	public static boolean isMaiorZero(final BigDecimal valor) {
		return UtilObjeto.isNotNull(valor) && valor.doubleValue() > 0;
	}

	public static boolean isMaiorIgualZero(final BigDecimal valor) {
		return UtilObjeto.isNotNull(valor) && valor.doubleValue() >= 0;
	}

	public static boolean isIgualAZero(final BigDecimal valor) {
		return UtilObjeto.isNotNull(valor) && valor.doubleValue() == 0;
	}

	public static boolean isMenorIgualQue(final BigDecimal valor1, final BigDecimal valor2) {
		return (isMaiorZero(valor1) && isMaiorZero(valor2))
				&& (valor1.doubleValue() < valor2.doubleValue() || valor1.doubleValue() == valor2.doubleValue());
	}

	public static boolean isMenorIgualA(final BigDecimal valor1, final BigDecimal valor2) {
		return (isMaiorZero(valor1) && isMaiorZero(valor2))
				&& (valor1.doubleValue() < valor2.doubleValue() || valor1.doubleValue() == valor2.doubleValue());
	}

	public static boolean isMaiorIgualQue(final BigDecimal valor1, final BigDecimal valor2) {
		return (isMaiorZero(valor1) && isMaiorZero(valor2))
				&& (valor1.doubleValue() > valor2.doubleValue() || valor1.doubleValue() == valor2.doubleValue());
	}

	public static boolean isIgual(final BigDecimal valor1, final BigDecimal valor2) {
		return (isMaiorZero(valor1) && isMaiorZero(valor2)) && valor1.doubleValue() == valor2.doubleValue();
	}

	public static boolean isMaiorQue(final BigDecimal valor1, final BigDecimal valor2) {
		return (isMaiorZero(valor1) && isMaiorZero(valor2)) && valor1.doubleValue() > valor2.doubleValue();
	}

	public static boolean isMenorQue(final BigDecimal valor1, final BigDecimal valor2) {
		return (isMaiorZero(valor1) && isMaiorZero(valor2)) && valor1.doubleValue() < valor2.doubleValue();
	}

	public static boolean isDirerente(final BigDecimal valor1, final BigDecimal valor2) {
		return (isMaiorZero(valor1) && isMaiorZero(valor2)) && valor1.doubleValue() != valor2.doubleValue();
	}

	public static boolean isMenorDoQueZero(final BigDecimal valor1) {
		BigDecimal valor = UtilObjeto.isNotNull(valor1) ? valor1 : BigDecimal.ZERO;
		return (valor.doubleValue() < 0);
	}

	public static boolean isPrimeiroMaiorDoQueSegundo(BigDecimal valor1, BigDecimal valor2) {
		valor1 = UtilObjeto.isNull(valor1) ? BigDecimal.ZERO : valor1;
		valor2 = UtilObjeto.isNull(valor1) ? BigDecimal.ZERO : valor2;
		return (valor1.doubleValue() > valor2.doubleValue());
	}
}
