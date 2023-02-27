package br.com.agro.msagro.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.agro.msagro.enums.TipoParceiroEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_funcao_parceiro")
public class FuncaoParceiro extends Entidade {

	private static final long serialVersionUID = 359961099961516528L;

	@Enumerated(EnumType.STRING)
	@Column(name = "desc_tipo_parceiro")
	private TipoParceiroEnum tipoParceiro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parceiro", referencedColumnName = "id")
	private Parceiro parceiro;

	@Column(name = "flag_bp_sincronizado", nullable = false, columnDefinition = "bit default 0")
	private boolean sincronizado;

	@Transient
	private String codParceiro;

	@Transient
	private String descFuncaoParceiro;
	

}
