package br.com.agro.msagro.util;

import java.io.File;
import java.util.Collection;
import java.util.Date;
import java.util.Map;


@SuppressWarnings("unchecked")
public final class UtilObjeto {

	
	private UtilObjeto() {

		super();
	}

	
	public static boolean isNull(final Object obj) {

		return obj == null;
	}

	
	public static boolean isNotNull(final Object obj) {

		return !isNull(obj);
	}

	public static boolean isNull(final Object... objects) {

		final boolean existeNull = Boolean.FALSE;

		if (UtilObjeto.isNotNull(objects)) {

			for (final Object obj : objects) {

				if (UtilObjeto.isNull(obj)) {

					return Boolean.TRUE;
				}
			}

		}
		return existeNull;
	}

	
	public static <T> Class<T> getClazz(final T objeto) {

		Class<T> classe = null;

		if (!UtilObjeto.isNull(objeto)) {

			classe = UtilObjeto.isClazz(objeto) ? (Class<T>) objeto : (Class<T>) objeto.getClass();
		}

		return classe;
	}

	
	public static boolean isClazz(final Object objeto) {

		return UtilObjeto.isObjetoDoTipo(objeto, Class.class);
	}

	
	public static boolean isColecao(final Object objeto) {

		return UtilObjeto.isObjetoDoTipo(objeto, Collection.class);
	}

	
	public static boolean isComparable(final Object objeto) {

		return UtilObjeto.isObjetoDoTipo(objeto, Comparable.class);
	}

	
	public static boolean isDate(final Object objeto) {

		return UtilObjeto.isObjetoDoTipo(objeto, Date.class);
	}

	
	public static boolean isSqlDate(final Object objeto) {

		return UtilObjeto.isObjetoDoTipo(objeto, java.sql.Date.class);
	}

	
	private static boolean isObjetoDoTipo(final Object objeto, final Class<?> tipo) {

		boolean res = false;

		if (!UtilObjeto.isNull(objeto, tipo)) {

			final Class<?> classe = UtilObjeto.getClazz(objeto);

			res = tipo.isAssignableFrom(classe);
		}

		return res;
	}

	public static boolean isNullOrEmpty(String value) {

		return ( value == null ) || ( value.trim().length() == 0 );
	}

	public static boolean isNullOrEmpty(Object value) {

		return value == null;
	}

	public static <T> boolean isNullOrEmpty(Collection<T> collection) {

		return ( collection == null ) || ( collection.isEmpty() );
	}

	public static boolean isNullOrEmpty(Number number) {

		return ( number == null ) || ( !( number.doubleValue() > 0 ) );
	}

	public static boolean isNullOrEmpty(Date data) {

		return data == null;
	}

	public static <T> boolean isNullOrEmpty(Map<T, T> map) {

		return ( map == null ) || ( map.isEmpty() );
	}

	public static boolean isNullOrEmpty(File file) {

		return isNull(file) || file.length() == 0;
	}

	public static boolean isNullOrEmpty(Object[] array) {

		return ( array == null ) || ( array.length == 0 );
	}
}
