package br.com.agro.msagro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class DateConverter {

	public static LocalDateTime getPrimeiroDiaDoMes(LocalDateTime data) {
		return LocalDateTime.of(data.getYear(), data.getMonth(), 1, 0, 0);
	}

	public static LocalDateTime getUltimoDiaDoMes(LocalDateTime data) {
		return LocalDateTime.of(data.getYear(), data.getMonth(), 1, 23, 59).with(TemporalAdjusters.lastDayOfMonth());
	}

	public static Date localDateToDate(LocalDate localDate) {
		try {
			return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		} catch (Exception e) {
			return null;
		}
	}

	public static Date localDateTimeToDate(LocalDateTime localDate) {
		try {
			return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
		} catch (Exception e) {
			return null;
		}
	}

	public static String localDateTimeToStringBr(LocalDateTime date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			return date.format(formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um LocalDateTime com a data informada
	 * 
	 * @param
	 * @return
	 */
	public static LocalDateTime stringTimeBrToLocalDateTime(String string) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
			return LocalDateTime.parse(string, formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma uma string com o formato passado por parametro do LocalDate
	 * informado
	 * 
	 * @param date
	 * @param formato
	 * @return
	 */
	public static String localDateToString(LocalDate date, String formato) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
			return date.format(formatter);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato passado por parametro do LocalDateTime
	 * informado
	 * 
	 * @param date
	 * @param formato
	 * @return
	 */
	public static String localDateTimeToString(LocalDateTime date, String formato) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
			return date.format(formatter);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma uma string da data passada no formato informado por parametro
	 * 
	 * @param LocalDate
	 * @param formato
	 * @return
	 */
	public static LocalDate stringToLocalDate(String data, String formato) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
			return LocalDate.parse(data, formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma uma string da data passada no formato informado por parametro
	 * 
	 * @param LocalDateTime
	 * @param formato
	 * @return
	 */
	public static LocalDateTime stringToLocalDateTime(String data, String formato) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
			return LocalDateTime.parse(data, formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato dd/MM/yyyy
	 * @return
	 */
	public static LocalDate stringBrToLocalDate(String string) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return LocalDate.parse(string, formatter);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato yyyy-MM-dd HH:mm do Calendar informado
	 * 
	 * @param calendar
	 * @return
	 */
	public static String localDateTimeToString(LocalDateTime date) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return date.format(formatter);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma um LocalDateTime com a data informada
	 * 
	 * @param string com o formato yyyy-MM-dd HH:mm
	 * @return
	 */
	public static LocalDateTime stringTimeToLocalDateTime(String string) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			return LocalDateTime.parse(string.replace("T", " "), formatter);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato dd/MM/yyyy HH:mm
	 * @return
	 */
	public static Calendar stringTimeBrToCalendar(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Transforma uma string em um Calendar de acordo com o pattern passado
	 * 
	 * @param string:  data em formato de string
	 * @param pattern: formato passado na string
	 * @return
	 */
	public static Calendar stringToCalendar(String string, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato dd/MM/yyyy
	 * @return
	 */
	public static Calendar stringBrToCalendar(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato yyyy-MM-dd HH:mm do Calendar informado
	 * 
	 * @param calendar
	 * @return
	 */
	public static String calendarToStringTime(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return sdf.format(calendar.getTime());
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato yyyy-MM-dd HH:mm
	 * @return
	 */
	public static Calendar stringTimeToCalendar(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato dd/MM/yyyy do Calendar informado
	 * 
	 * @param calendar
	 * @return
	 */
	public static String calendarToStringBr(Calendar calendar) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.format(calendar.getTime());
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato passado por parametro do Calendar
	 * informado
	 * 
	 * @param calendar
	 * @param formato
	 * @return
	 */
	public static String calendarToString(Calendar calendar, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		try {
			return sdf.format(calendar.getTime());
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma uma string com o formato passado por parametro do Date informado
	 * 
	 * @param date
	 * @param formato
	 * @return
	 */
	public static String dateToString(Date date, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		try {
			return sdf.format(date.getTime());
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma o Calendar em um XMLGregorianCalendar
	 * 
	 * @param Calendar
	 * @return XMLGregorianCalendar
	 */
	public static XMLGregorianCalendar calendarToXMLGregorianCalendar(Calendar calendar) {
		try {
			Date cDate = calendar.getTime();
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(cDate);
			return DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR),
					cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma um Date em String com formato aceito no SAP
	 * 
	 * @param data
	 * @return
	 */
	public static String formatToSAP(final Date data) {
		return new SimpleDateFormat("yyyy/MM/dd").format(data).replaceAll("/", "");
	}

	/**
	 * Transforma um LocalDate em String com formato aceito no SAP
	 * 
	 * @param data
	 * @return
	 */
	public static String formatToSAP(final LocalDate data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			return data.format(formatter).replaceAll("/", "");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um LocalDateTime em String com formato aceito no SAP
	 * 
	 * @param data
	 * @return
	 */
	public static String formatToSAP(final LocalDateTime data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			return data.format(formatter).replaceAll("/", "");
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um Date em String com a hora no formato aceito no SAP
	 * 
	 * @param data
	 * @return
	 */
	public static String formatHora(Date data) {
		return new SimpleDateFormat("HHmmss").format(data);
	}

	/**
	 * Transforma um LocalDate em String com a hora no formato aceito no SAP
	 * 
	 * @param data
	 * @return
	 */
	public static String formatHora(final LocalDate data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
			return data.format(formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um LocalDateTime em String com a hora no formato aceito no SAP
	 * 
	 * @param data
	 * @return
	 */
	public static String formatHora(final LocalDateTime data) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
			return data.format(formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um LocalDateTime com a data informada
	 * 
	 * @param string com o formato yyyyMMdd (enviado pelo SAP)
	 * @return
	 */
	public static LocalDateTime obterLocalDateTimeFormatoSAP(String string) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			return LocalDateTime.parse(string, formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um LocalDate com a data informada
	 * 
	 * @param string com o formato yyyyMMdd (enviado pelo SAP)
	 * @return
	 */
	public static LocalDate obterLocalDateFormatoSAP(String string) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
			return LocalDate.parse(string, formatter);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um Calendar com a data informada
	 * 
	 * @param string com o formato yyyyMMdd (enviado pelo SAP)
	 * @return
	 */
	public static Calendar obterDataFormatoSAP(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date;
		try {
			date = sdf.parse(string);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			return cal;
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Transforma um java.util.date em um Calendar
	 * 
	 * @param date
	 * @return
	 */
	public static Calendar dateToCalendar(Date date) {
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Transforma um java.util.date em um Calendar
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDateTime dateToLocalDateTime(Date date) {
		try {
			return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Transforma um java.util.date em um Calendar
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate dateToLocalDate(Date date) {
		try {
			return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * Calcula a diferença em dias entre duas datas
	 * 
	 * @param date1
	 * @param date2
	 * @return quantidade de dias
	 */
	public static Integer getDiferencaDias(Calendar date1, Calendar date2) {
		return (int) ChronoUnit.DAYS.between(date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	/**
	 * Calcula a diferença em dias entre duas datas
	 * 
	 * @param date1
	 * @param date2
	 * @return quantidade de dias
	 */
	public static Integer getDiferencaDias(LocalDate date1, LocalDate date2) {
		return (int) ChronoUnit.DAYS.between(date1.atStartOfDay().atZone(ZoneId.systemDefault()).toLocalDate(),
				date2.atStartOfDay().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	/**
	 * Calcula a diferença em dias entre duas datas
	 * 
	 * @param date1
	 * @param date2
	 * @return quantidade de dias
	 */
	public static Integer getDiferencaDias(LocalDateTime date1, LocalDateTime date2) {
		return (int) ChronoUnit.DAYS.between(date1.atZone(ZoneId.systemDefault()).toLocalDate(),
				date2.atZone(ZoneId.systemDefault()).toLocalDate());
	}

	/**
	 * Calcula a diferença em meses entre duas datas
	 * 
	 * @param date1
	 * @param date2
	 * @return quantidade de meses
	 */
	public static Integer getDiferencaMeses(LocalDate date1, LocalDate date2) {
		return (int) ChronoUnit.MONTHS.between(date1.atStartOfDay().atZone(ZoneId.systemDefault()).toLocalDate(),
				date2.atStartOfDay().atZone(ZoneId.systemDefault()).toLocalDate());
	}

	public static Integer anoBySafra(String safra) {
		String[] s = safra.split("/");
		Integer ano = Integer.valueOf(s[1]);

		return ano;

	}

	public static Date stringToDate(String data, String formato) {
		try {
			return new SimpleDateFormat(formato).parse(data);
		} catch (ParseException e) {
			String metodo = new Object() {
			}.getClass().getEnclosingMethod().getName();
			String classe = new Object() {
			}.getClass().getName();
			System.err.println(
					classe + " | " + metodo + " | " + e.getStackTrace()[0].getLineNumber() + " | " + e.getMessage());
			return null;
		}

	}

	public static String getMonthByNumber(int monthValue) {
		switch (monthValue) {
		case 1:

			return "Janeiro";
		case 2:

			return "Fevereiro";
		case 3:

			return "Março";
		case 4:

			return "Abril";
		case 5:

			return "Maio";
		case 6:

			return "Junho";
		case 7:

			return "Julho";
		case 8:

			return "Agosto";
		case 9:

			return "Setembro";
		case 10:

			return "Outubro";
		case 11:

			return "Novembro";
		case 12:

			return "Dezembro";

		default:
			return null;
		}

	}

	public static boolean isDate(Object object) {
		String strDate = object.toString();
		return DateConverter.stringBrToLocalDate(strDate) != null
				|| DateConverter.stringTimeBrToLocalDateTime(strDate) != null
				|| DateConverter.stringTimeToLocalDateTime(strDate) != null
				|| DateConverter.stringToLocalDate(strDate, "yyyy-MM-dd") != null
				|| DateConverter.stringToLocalDateTime(strDate, "yyyy-MM-dd HH:mm") != null;
	}

}
