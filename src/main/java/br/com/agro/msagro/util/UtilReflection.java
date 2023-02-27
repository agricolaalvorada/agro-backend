package br.com.agro.msagro.util;

import java.lang.reflect.Field;
import java.util.logging.Logger;


public class UtilReflection {


	private static final String PATTERN = "\\.";


	private static final Logger LOG = Logger.getLogger(UtilReflection.class.getSimpleName());

	
	public static Object getValor(final String campo, final Object entidade) {

		try {

			final Field field = entidade.getClass().getDeclaredField(campo);

			field.setAccessible(true);

			return field.get(entidade);

		} catch (final Exception e) {

			UtilReflection.LOG.severe(e.getMessage());

			return null;

		}

	}

	
	public static boolean isNull(final Object entidade, final String campo) {

		final String[] dados = campo.split(PATTERN);

		Object pesquisador = entidade;

		for (final String valor : dados) {

			final Object item = UtilReflection.getValor(valor, pesquisador);

			if (UtilObjeto.isNullOrEmpty(item) || ( UtilObjeto.isNotNull(item) && UtilString.isEmptyNull(item.toString()) )) {

				return true;
			}

			pesquisador = item;

		}

		return false;
	}

	
	public static Object getNullOrValue(final Object entidade, final String campo) {

		final String[] dados = campo.split(PATTERN);

		Object pesquisador = entidade;

		for (final String valor : dados) {

			final Object item = UtilReflection.getValor(valor, pesquisador);

			if (UtilObjeto.isNull(item)) {

				return null;
			}

			pesquisador = item;

		}

		return pesquisador;
	}

	
	public static String getNullOrValueString(final Object entidade, final String campo) {

		final String[] dados = campo.split(PATTERN);

		Object pesquisador = entidade;

		for (final String valor : dados) {

			final Object item = UtilReflection.getValor(valor, pesquisador);

			if (UtilObjeto.isNull(item)) {

				return null;
			}

			pesquisador = item;

		}

		return pesquisador.toString();
	}

}
