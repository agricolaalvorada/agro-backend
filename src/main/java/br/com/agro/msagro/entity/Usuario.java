package br.com.agro.msagro.entity;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.agro.msagro.dto.UsuarioDTO;
import br.com.agro.msagro.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario extends EntidadeAmbiente implements UserDetails{

	private static final long serialVersionUID = -6243722706286940580L;

	@Column(name = "nome")
	private String nome;

	@Column(name = "codg_usuario", length = 60)
	private String codigo;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	@JsonIgnore
	private String senha;

	@Column(name = "data_ultimo_acesso")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dataUltimoAcesso;

	@Column(name = "data_expiracao_acesso")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date dataExpiracaoAcesso;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@Column(name = "quantidade_erros_senha")
	@JsonIgnore
	private int quantidadeErrosSenha;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "tb_usuario_perfil", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
	@JoinColumn(name = "id_perfil") })
	@JsonIgnore
	private Set<Perfil> perfis;

	@Column(name = "sessao_web", length = 40)
	@JsonIgnore
	private String sessaoWeb;

	@Transient
	@JsonIgnore
	private Date dataUltimoAcessoAnterior;

	@Transient
	@JsonIgnore
	private String ipDoUsuario;

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return perfis;
	}

	@Override
	@JsonIgnore
	public String getPassword() {
		return senha;
	}

	@Override
	@JsonIgnore
	public String getUsername() {
		return login;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		return true;
	}
	
	public UsuarioDTO toDTO() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<UsuarioDTO>() {});
	}
	
}
