package br.com.agro.msagro.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class UtilColecao {

	private UtilColecao() {
		super();
	}

	public static <T extends Comparable<? super T>> Collection<T> ordenar(final Collection<T> colecao) {
		List<T> resultado = null;
		if (UtilColecao.isReferencia(colecao)) {
			resultado = new ArrayList<T>(colecao);
			Collections.sort(resultado);
		}
		return resultado;
	}

	public static <T> Collection<T> ordenar(final Collection<T> colecao, final Comparator<? super T> comparator) {
		if (UtilObjeto.isNotNull(colecao) && UtilObjeto.isNotNull(comparator)) {
			Collections.sort((List<T>) colecao, comparator);
		}
		return colecao;
	}

	public static <T> T getElementoDoIndice(final List<T> lista, final int indice) {
		T resultado = null;
		if (!UtilColecao.isEmpty(lista) && indice >= 0 && indice < lista.size()) {
			resultado = lista.get(indice);
		}
		return resultado;
	}

	public static <T> T getElementoDoIndice(final Collection<T> colecao, final int indice) {
		final List<T> lista = new ArrayList<T>(colecao);
		return UtilColecao.getElementoDoIndice(lista, indice);
	}

	public static <T> T getElementoDoUltimoIndice(final Collection<T> colecao) {
		final List<T> lista = new ArrayList<T>(colecao);
		final int indice = (lista.size() - 1);
		return UtilColecao.getElementoDoIndice(lista, indice);
	}

	public static int getTamanho(final Collection<?> colecao) {
		int resultado = 0;
		if (UtilColecao.isReferencia(colecao)) {
			resultado = colecao.size();
		}
		return resultado;
	}

	public static boolean isEmpty(final Collection<?> colecao) {
		return (colecao == null || UtilColecao.getTamanho(colecao) == 0);
	}

	public static boolean isNotEmpty(final Collection<?> colecao) {
		return !UtilColecao.isEmpty(colecao);
	}

	public static boolean isReferencia(final Object objeto) {
		return !UtilObjeto.isNull(objeto);
	}
}
