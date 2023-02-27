package br.com.agro.msagro.entity;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.NotNull;

import br.com.agro.msagro.dto.DestinoCargaDescargaDTO;
import br.com.agro.msagro.dto.ParceiroDTO;
import br.com.agro.msagro.enums.CategoriaCNHEnum;
import br.com.agro.msagro.enums.StatusCadastroEnum;
import br.com.agro.msagro.enums.StatusEnum;
import br.com.agro.msagro.enums.StatusInscEstadualEnum;
import br.com.agro.msagro.enums.StatusRegistroEnum;
import br.com.agro.msagro.enums.TipoLocalidadeEnum;
import br.com.agro.msagro.enums.TipoParceiroEnum;
import br.com.agro.msagro.enums.TipoPessoaEnum;
import br.com.agro.msagro.enums.TipoSubcontratadoEnum;
import br.com.agro.msagro.util.UtilObjeto;
import br.com.agro.msagro.util.UtilString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_parceiro")
public class Parceiro extends EntidadeAmbiente {

	private static final long serialVersionUID = 5320421441043260436L;

	@Column(name = "e_fornecedor", nullable = false, columnDefinition = "bit default 0")
	private boolean fornecedor;

	@Enumerated(EnumType.STRING)
	@Column(name = "des_tipo_pessoa")
	private TipoPessoaEnum tipoPessoa;

	@Enumerated(EnumType.STRING)
	@Column(name = "des_tipo_subcontratado")
	private TipoSubcontratadoEnum tipoSubcontratado;

	@Enumerated(EnumType.STRING)
	@Column(name = "des_tipo_localidade")
	private TipoLocalidadeEnum tipoLocalidade;

	@Column(name = "cod_parceiro")
	private String codigo;

	@Column(name = "nm_parceiro")
	private String nome;

	@Column(name = "nr_cpf")
	private String cpf;

	@Column(name = "nr_cnpj")
	private String cnpj;

	@Column(name = "nm_fazenda")
	private String fazenda;

	@Column(name = "des_logradouro")
	private String logradouro;

	@Column(name = "nm_bairro")
	private String bairro;

	@Column(name = "nm_municipio")
	private String municipio;

	@Column(name = "nr_cartao_repom", length = 9)
	private String nrCartaoRepom;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_estado")
	private Estado estado;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_municipio")
	private Cidade cidade;

	@Column(name = "ds_complemento")
	private String complemento;

	@Column(name = "nr_endereco")
	private String numeroEndereco;

	@Column(name = "nr_parceiro")
	private String numero;

	@Column(name = "nm_cep")
	private String cep;

	@Column(name = "nm_telefone")
	private String telefone;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_cadastro")
	private StatusCadastroEnum statusCadastro;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_parceiro")
	private StatusEnum statusParceiro;

	@Column(name = "tp_bloqueio")
	private String tipoBloqueio;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_registro_sap")
	private StatusRegistroEnum status;

	@Column(name = "log_sap")
	private String logSAP;

	@Enumerated(EnumType.STRING)
	@Column(name = "status_insc_estadual")
	private StatusInscEstadualEnum statusInscEstadual;

	@Column(name = "nm_ins_estadual")
	private String inscricaoEstadual;

	@Column(name = "nm_request_key")
	private String requestKey;

	@Column(name = "nr_cnh")
	private String cnh;

	@Column(name = "grupo_sap")
	private String grupo;

	@Column(name = "nr_formulario_cnh")
	private String formularioCnh;

	@Column(name = "nr_seguranca_cnh")
	private String segurancaCnh;

	@Column(name = "nr_registro_geral")
	private String numeroRg;

	@Column(name = "orgao_emissor_rg")
	private String orgaoEmissorRg;

	@Column(name = "nr_pis")
	private String numeroPis;

	@Column(name = "nr_celular")
	private String celular;

	@Column(name = "nr_cei")
	private String cei;

	@Column(name = "ds_email")
	private String email;

	@Column(name = "nr_rntrc")
	private String numeroRntrc;

	@Column(name = "ds_jobbr")
	private String jobbr;

	@Column(name = "identificador_filial")
	private String identificadorFilial;

	@Column(name = "dt_emissao_rg")
	private Date dataEmissaoRg;

	@Column(name = "dt_emissao")
	private Date dataEmissao;

	@Column(name = "dt_primeira_habilitacao")
	private Date dataPrimeiraHabilitacao;

	@Column(name = "dt_validade_cnh")
	private Date dataValidadeCnh;

	@Column(name = "dt_validade_rntrc")
	private Date dataValidadeRntrc;

	@Column(name = "dt_nascimento")
	private Date dataNascimento;

	@Enumerated(EnumType.STRING)
	@Column(name = "ds_categoria_cnh")
	private CategoriaCNHEnum catergoriaCnh;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_parceiro_request_key", joinColumns = {
			@JoinColumn(name = "id_parceiro") }, inverseJoinColumns = { @JoinColumn(name = "id_request") })
	private Set<RequestKey> requests;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parceiro")
	private Collection<FuncaoParceiro> funcoesParceiro;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "des_tipo_parceiro")
	private TipoParceiroEnum tipoParceiro;

	@ManyToOne
	@JoinColumn(name = "id_empresa", referencedColumnName = "id")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "id_organizacao_compras", referencedColumnName = "id")
	private OrganizacaoCompras organizacaoCompras;

	@ManyToOne
	@JoinColumn(name = "id_usuario_cad")
	private Usuario usuarioCadastro;

	@ManyToOne
	@JoinColumn(name = "id_usuario_alt")
	private Usuario usuarioAlteracao;

	@Column(name = "bloqueio_moratoria_soja", nullable = false, columnDefinition = "bit default 0")
	private boolean bloqueioMoratoriaSoja;

	@Transient
	private boolean preCadastro;

	
	public String getRecebedorParceiro() {
		String codigo = this.getCodigo();
		String nomeParceiro = this.getNome();
		String telefone = UtilString.isNotEmptyNull(this.getTelefone()) ? this.getTelefone() : UtilString.empty();
		String cnpj = UtilString.isNotEmptyNull(this.cnpj) ? this.cnpj : UtilString.empty();
		String cidade = UtilObjeto.isNotNull(this.getCidade()) ? this.getCidade().getCidadeFormatada()
				: UtilString.empty();
		String endereco = UtilString.isNotEmptyNull(this.getLogradouro()) ? ", " + this.getLogradouro()
				: UtilString.empty();
		String numero = UtilString.isNotEmptyNull(this.getNumero()) ? ", " + this.getNumero() : ", S/N";
		return codigo.concat(" - ").concat(nomeParceiro) + "\n"
				+ "Filial ".concat(codigo).concat(" - ").concat(telefone).concat(" CNPJ: ").concat(cnpj) + "\n"
				+ cidade.concat(endereco).concat(numero);
	}

	@Override
	public String toString() {
		if (UtilString.isNotEmptyNull(this.codigo)) {
			return this.codigo + " - " + this.nome;
		} else {
			return this.nome;
		}
	}

	public ParceiroDTO toDTO() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<ParceiroDTO>() {});
	}
	
}
