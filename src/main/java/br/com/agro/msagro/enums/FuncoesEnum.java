package br.com.agro.msagro.enums;

public enum FuncoesEnum {

    CAD_AMBIENTE("Cadastro de Ambiente SAP", "ManterAmbienteController"),
    CAD_USUARIOS("Cadastro de Usuário", "ManterUsuarioController"),
    CAD_MOTORISTAS("Cadastro de Motorista", "ManterMotoristaController"),
    CAD_VEICULOS("Cadastro de Veiculo", "ManterVeiculoController"),
    CAD_PERFIL("Cadastro de Perfil", "ManterPerfilController"),
    CAD_PRODUTOR("Cadastro de Parceiro", "ManterProdutorController"),
    ATRIBUIR_PERFIL("Atribuir Perfil", "AtribuirPerfilController"),
    CAD_PARAMETRO("Parâmetro de Integração", "ManterParametroIntegracaoController"),
    CAD_CLASSIFICACAO("Cadastro de Classificação", "ManterClassificacaoController"),
    CAD_ROMANEIO("Cadastro de Romaneio", "ManterRomaneioController"),
    GERENCIAMENTO_FILA_ROMANEIO("Gerenciamento Fila Romaneio", "ManterGerenciamentoFilaPesagemController"),
    MONITOR_FILA_ROMANEIO("Monitor Fila Romaneio", "ManterMonitorFilaPesagemController"),
    VALIDAR_ROMANEIO_AUTOMACAO("Validar Romaneios Automação", "ManterValidarRomaneioAutomacaoController"),

    MONITOR_FILA_CLASSIFICACAO("Monitor Fila Classificação", "ManterMonitorClassificacaoAutomacaoController"),
    CLASSIFICACAO_FILA_ROMANEIO("Classificação Fila Romaneio", "ManterClassificacaoFilaPesagemController"),
    ALTERAR_DADOS_ROMANEIO_SAP("Alterar Dados do Romaneio no SAP", "ManterAlterarDadosRomaneioSAPController"),

    PESAGEM("Cadasto de Pesagem", "ManterPesagemController"),
    CONF_JOB("Configuração de Job", "ManterConfiguracaoJobController"),
    BALANCA_MAQUINA("Permissão de Balança por Máquina", "ManterBalancaMaquinaController"),
    BALANCA_CONTINGENCIA("Permissão de Balança em Contingência", "ManterBalancaControllerContingencia"),
    AUTORIZACAO_RETIRADA_FRETE("Permissão para alteração de frete na autorização de retirada.",
            "ManterAutorizacaoDeRetirada"),
    BALANCA("Cadastro de Balança", "ManterBalancaController"),
    TRANGENIA("Cadastro de Transgenia", "ManterTransgeniaController"),
    RELATORIOS_CD("Relatórios Carga/Descarga", "ManterRelatorioController"),
    CONFIGURACAO_CAMPO_ROMANEIO("Configuração de Campos", "ManterCampoRomaneioController"),
    IMP_DOC("Impressão de Documentos", "ManterImpressaoDocumentoController"),
    LOGS_CONFIGURACAO("Logs e Configurações de Envio de Romaneio", "ManterRomaneioLogEnvioController"),
    CONFIG_SAP("Configurações SAP", "ManterDadosSincronizacaoController"),
    ATRIBUIR_AMBIENTE("Atribuir Ambiente SAP", "AtribuirAmbienteController"),
    CERTIDAO("Certidão de Debito", "ManterCertidaoController"),
    SUBSTITUIR_CLASSIF_TRANSG_OP_SPOT("Substituir classificação e transgenia op Spot", "ManterClassficacaoController"),
    SUBSTITUIR_ROMANEIO_OPERACAO_SPOT("Substituir romaneio operação SPOT", "ManterRomaneioSPOTController"),
    CONSULTA_CHAVE_NFE("Consultar Chave NFE.", "ManterNotaController"),
    MAIOR_PERCENT_DESC_CLASSIF("Permitir lançamento com desconto superior ao permitido.",
            "ManterClassficacaoController"),
    GBO_LIBERACAO_DOCUMENTO("GBO - Liberação de Documentos.", "ManterDocumentoGBOController"),
    LANCAMENTO_PESO_ROMANEIO_DESTINO("Lançamento de Pesos Romeneios Destino", "ManterLancamentoPesoController"),
    CHAVE_ALTERA_PESO_ROMANEIO("Geração de Chaves para Alteração de Pesos de Romaneios",
            "ManterChaveAlteraPesoRomaneioController"),
    RATEIO_ROMANEIO_SPOT_MANUAL("Rateio de romaneios com operação SPOT", "ManterRateioRomaneioSpotController"),
    CRIAR_ROMANEIO_SPOT_PESO_SUPERIOR_CAPACIDADE_VEICULO(
            "Criar romaneio spot com peso superior a capacidade do veiculo", "ManterRateioRomaneioSpotController"),
    ELIMINAR_SEGUNDA_PESAGEM_ROMANEIO_EFETIVO_SAIDA("Eliminar segunda pesagem de Romaneio Efetivo de Saída",
            "ManterRateioRomaneioSpotController"),
    CAD_TAG("Cadastro de Tags", "ManterTagController"),
    CAD_DESTINO_CARGA_DESCARGA("Cadastro de Destinos Carga e Descarga", "ManterDestinoCargaDescargaController"),
    CRITICA_AUTOMACAO_PESAGEM("Acompanhamento de Críticas da Automação", "ManterCriticaAutomacaoPesagemController"),
    ALTERAR_CLASSIFICACAO_SAP("Alterar classificação no Agro e no SAP", "ManterClassficacaoController"),

    ALTERAR_TRANSGENIA_ROMANEIO_SAP("Permitir aleração da transgenia do romaneio", "ManterAlterarDadosRomaneioSAPController"),

    ALTERAR_ARMAZEM_ROMANEIO_SAP("Permitir aleração do armazem do romaneio", "ManterAlterarDadosRomaneioSAPController");




    private String descricao;
    private String simpleName;

    FuncoesEnum(final String descricao, final String simpleName) {
        this.setDescricao(descricao);
        this.setSimpleName(simpleName);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

}
