package br.com.agro.msagro.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tb_request_key")
public class RequestKey extends Entidade {

	private static final long serialVersionUID = 1L;

	@Column(name = "ds_request_key", length = 255)
	private String request;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dt_request")
	private Date dataRequest;

}
