package br.com.agro.msagro.enums;

import java.util.Arrays;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

public enum TipoParceiroEnum {

	GERAL("Z000", "Parceiro de Negócios Geral"), FUNCIONARIO("Z001", "Funcionário"), MOTORISTA("Z002", "Motorista"),
	PRODUTOR("Z003", "Produtor"), FAZENDA("Z004", "Fazenda"), MATRICULA("Z005", "Matrícula"),
	TRANSPORTADORA("Z006", "Transportadora"), EMPRESA("Z007", "Empresa"), TERCEIRO("Z010", "Terceiro"),
	CLASSIFICADOR("Z001", "Classificador"), REPRESENTANTE_RTV("Z012", "Representante RTV"),
	GERENTE_VENDAS("Z013", "Gerente de vendas"), COORDENADOR_VENDAS("Z014", "Coordenador de vendas"),
	FILIAL("Z015", "Filial"), DEPOSITANTE("Z017", "Depositante"), EXTERIOR("Z018", "EXTERIOR"),
	BANCOS("Z019", "Bancos"), MICROPRODUTOR("Z020", "Fazenda Microprodutora"),
	ARMAZEM_TERCEIRO("Z021", "Armazém de terceiro"), PRE_CADASTRO("ZPRE", "Pré Cadastro"),
	ARMAZEM_PARTICIPANTE("Z022", "Armazém participante");

	@Getter
	@Setter
	private String codigo;
	@Getter
	@Setter
	private String descricao;
	@Getter
	@Setter
	private boolean atualizado;

	private TipoParceiroEnum(String codigo, String descricao) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
	}

	public static TipoParceiroEnum obterTipoParceiroPorCodigo(String tipoParceiro) {
		for (TipoParceiroEnum tipo : TipoParceiroEnum.values()) {
			if (tipo.getCodigo().equals(tipoParceiro)) {
				return tipo;
			}
		}
		return null;
	}

	
	public static TipoParceiroEnum obterPorCodigo(String value) {
		for (TipoParceiroEnum tipo : TipoParceiroEnum.values()) {
			if (tipo.getCodigo().equals(value)) {
				return tipo;
			}
		}
		return null;
	}

	public static TipoParceiroEnum get(String name) {
		for (TipoParceiroEnum tipo : TipoParceiroEnum.values()) {
			if (tipo.name().equals(name)) {
				return tipo;
			}
		}
		return null;
	}

	public static Collection<TipoParceiroEnum> getListaFuncoesParceiro() {
		return Arrays.asList(new TipoParceiroEnum[] { TipoParceiroEnum.FAZENDA, TipoParceiroEnum.TRANSPORTADORA,
				TipoParceiroEnum.EMPRESA, TipoParceiroEnum.TERCEIRO, TipoParceiroEnum.MICROPRODUTOR });
	}
}
