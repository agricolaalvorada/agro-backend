package br.com.agro.msagro.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.agro.msagro.enums.FuncoesEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_funcionalidade")
public class Funcionalidade extends Entidade {

	private static final long serialVersionUID = 8842152695777388044L;

	@Enumerated(EnumType.STRING)
	private FuncoesEnum descricao;

	@ManyToOne
	@JoinColumn(name = "perfil_id")
	private Perfil perfil;

	private Boolean cadastrar;

	private Boolean alterar;

	private Boolean excluir;

	private Boolean consultar;
	
	private Boolean desenvolvedor;


}
