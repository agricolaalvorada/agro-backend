package br.com.agro.msagro.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.entity.Parceiro;
import br.com.agro.msagro.enums.CategoriaCNHEnum;
import br.com.agro.msagro.enums.StatusCadastroEnum;
import br.com.agro.msagro.enums.StatusEnum;
import br.com.agro.msagro.enums.StatusInscEstadualEnum;
import br.com.agro.msagro.enums.StatusRegistroEnum;
import br.com.agro.msagro.enums.TipoLocalidadeEnum;
import br.com.agro.msagro.enums.TipoParceiroEnum;
import br.com.agro.msagro.enums.TipoPessoaEnum;
import br.com.agro.msagro.enums.TipoSubcontratadoEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParceiroDTO extends EntidadeAmbienteDTO{

	private boolean fornecedor;

	private TipoPessoaEnum tipoPessoa;

	private TipoSubcontratadoEnum tipoSubcontratado;

	private TipoLocalidadeEnum tipoLocalidade;

	private String codigo;

	private String nome;

	private String cpf;

	private String cnpj;

	private String fazenda;

	private String logradouro;

	private String bairro;

	private String municipio;

	private String nrCartaoRepom;

	private EstadoDTO estadoDTO;

	private CidadeDTO cidadeDTO;

	private String complemento;

	private String numeroEndereco;

	private String numero;

	private String cep;

	private String telefone;

	private StatusCadastroEnum statusCadastro;

	private StatusEnum statusParceiro;

	private String tipoBloqueio;

	private StatusRegistroEnum status;

	private String logSAP;

	private StatusInscEstadualEnum statusInscEstadual;

	private String inscricaoEstadual;

	private String requestKey;

	private String cnh;

	private String grupo;

	private String formularioCnh;

	private String segurancaCnh;

	private String numeroRg;

	private String orgaoEmissorRg;

	private String numeroPis;

	private String celular;

	private String cei;

	private String email;

	private String numeroRntrc;

	private String jobbr;

	private String identificadorFilial;

	private Date dataEmissaoRg;

	private Date dataEmissao;

	private Date dataPrimeiraHabilitacao;

	private Date dataValidadeCnh;

	private Date dataValidadeRntrc;

	private Date dataNascimento;

	private CategoriaCNHEnum catergoriaCnh;

	private TipoParceiroEnum tipoParceiro;

	private EmpresaDTO empresaDTO;

	private OrganizacaoComprasDTO organizacaoComprasDTO;

	private UsuarioDTO usuarioCadastroDto;

	private UsuarioDTO usuarioAlteracaoUsuarioDTO;

	private boolean bloqueioMoratoriaSoja;

	private boolean preCadastro;
	
	
	public Parceiro toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(Visibility.ANY));
		return mapper.convertValue(this, new TypeReference<Parceiro>() {});
	}
	
}
