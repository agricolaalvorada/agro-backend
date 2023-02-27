package br.com.agro.msagro.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

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
@Table(name = "tb_perfil")
public class Perfil extends EntidadeAmbiente implements GrantedAuthority{

	
	private static final long serialVersionUID = -8706587321346814994L;

	@Column(name="nome")
	private String nome;

	@Column(name="permisao_pesagem_manual")
	private boolean pesagemManual;

	@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Funcionalidade> funcionalidades;

//	@OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Collection<PerfilOperacao> operacoes;

	
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	@ManyToMany(mappedBy = "perfis", fetch = FetchType.LAZY)
	private Collection<Usuario> usuario;

	@Override
	public String getAuthority() {
		return nome;
	}

}
