package br.com.agro.msagro.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;


public class UtilSql {

	private static final String MSG_ERRO_ABERTURA_FILE = "Erro na abertura do arquivo: %s.\n";

	public static void gerarFile(String nomeArquivo, String pathDiretorio, Collection<String> logs) {

		final StringBuilder fullSql = new StringBuilder();
		File arquivos[];
		final File diretorio = new File(pathDiretorio);
		arquivos = diretorio.listFiles();
		FileWriter arquivoFull;
		try {
			logs.add("Criando arquivo Full SQL");
			logs.add("Lendo scripts:\n");
			arquivoFull = new FileWriter(new File(pathDiretorio + nomeArquivo));
			for (int i = 0; i < arquivos.length; i++) {
				UtilSql.lerArquivos(arquivos[i].toString(), fullSql);
				logs.add(( ( i + 1 ) + " - " + arquivos[i].getName() ));
			}
			UtilSql.gravarArquivo(arquivoFull, fullSql.toString());
			arquivoFull.close();
			logs.add("\n Arquivo Full SQL criado com sucesso");
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	
	private static void lerArquivos(final String nome, final StringBuilder fullSql) {

		try {
			final FileReader arq = new FileReader(nome);
			final BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();

			while (linha != null) {
				fullSql.append(linha);
				fullSql.append("\n");
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (final IOException e) {
			System.err.printf(UtilSql.MSG_ERRO_ABERTURA_FILE, e.getMessage());
		}
	}

	
	private static void gravarArquivo(final FileWriter arquivo, final String fullSql) {

		try {
			arquivo.write(fullSql);
			arquivo.close();
		} catch (final IOException e) {
			e.printStackTrace();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
