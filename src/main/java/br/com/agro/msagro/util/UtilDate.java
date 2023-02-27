package br.com.agro.msagro.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class UtilDate {
    private static final String PATTERN = "dd/MM/yyyy";
    private static final String PATTERN_HORA = "HHmmss";

    public static Date hoje() {
        return new Date();
    }

    public static Date obterDataFormatoSAP(final String valor) {
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        sdf.setLenient(false);
        Date data = null;
        try {
            data = sdf.parse(valor);
        } catch (final ParseException e) {
        }
        return data;
    }

    public static Date adicionarDiasAData(Date data, Integer dias) {
        try {
            final GregorianCalendar gc = new GregorianCalendar();
            gc.setTime(data);
            gc.add(Calendar.DAY_OF_MONTH, dias);
            return gc.getTime();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isFinalDeSemana(final Date date) {
        final GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        final int diaDaSemana = gc.get(Calendar.DAY_OF_WEEK);
        return (diaDaSemana == 1 || diaDaSemana == 7);
    }

    public static String format(final Date data) {
        return UtilDate.format(data, UtilDate.PATTERN);
    }

    public static String format(final Date data, final String pattern) {
        if (UtilObjeto.isNotNull(data)) {
            final SimpleDateFormat dt = new SimpleDateFormat(pattern);
            return dt.format(data);
        }
        return null;
    }

    public static String getYear(final Date data) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    public static String getMonth(final Date data) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        return String.valueOf(calendar.get(Calendar.MONTH));
    }

    public static String formatToSAP(final Date data) {
        if (UtilObjeto.isNull(data)) {
            return UtilString.empty();
        }
        return new SimpleDateFormat("yyyy/MM/dd").format(data).replaceAll("/", "");
    }

    public static String formatHora(final Date data) {
        if (UtilObjeto.isNull(data)) {
            return UtilString.empty();
        }
        return new SimpleDateFormat(UtilDate.PATTERN_HORA).format(data);
    }

    public static String dataHoraAtual() {
        return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("pt", "BR")).format(UtilDate.hoje());
    }

    public static int obterNumeroDiasEntreData(final Date data1, final Date data2) {
        try {
            final Calendar cal1 = new GregorianCalendar();
            final Calendar cal2 = new GregorianCalendar();
            cal1.setTime(data1);
            cal2.setTime(data2);
        } catch (final Exception e) {
            return 0;
        }
        return (int) (((data2.getTime() - data1.getTime()) + 3600000) / 86400000);
    }

    public static Date obterDataAtualHoraZerada() {
        Date data = null;
        try {
            final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            data = format.parse(format.format(new Date()));
            return data;
        } catch (final ParseException e) {
            return data;
        }
    }

    public static Date obterDataHoraZerada(Date data) {
        try {
            final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            data = format.parse(format.format(data));
            return data;
        } catch (final ParseException e) {
            return data;
        }
    }

    public static Date converterDateFimDia(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static Date subtrairMinutos(Date data, Integer minutos) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MINUTE, minutos);
        return cal.getTime();
    }

    public static Date converterDateFutura(Integer dia, Integer mes, Integer ano) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, dia);
        cal.set(Calendar.MONTH, mes - 1);
        cal.set(Calendar.YEAR, ano);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    public static String datePorExtenso(Date data) {
        try {
            DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy");
            return dfmt.format(data);
        } catch (Exception e) {
            return UtilString.empty();
        }
    }
}
