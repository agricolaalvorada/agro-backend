package br.com.agro.msagro.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Entidade implements Serializable {

	private static final long serialVersionUID = 2325166658203959465L;

	@Transient
	@JsonIgnore
	private String uuid = UUID.randomUUID().toString();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "numeric(19,0)")

	private Long id;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUuid() {
		return this.uuid;
	}

	@Transient
	public void setUuid(final String uuid) {
		if (StringUtils.hasLength(uuid)) {
			return;
		}
		this.uuid = uuid;
	}

	@Override
	public boolean equals(final Object object) {
		if (object == this) {
			return Boolean.TRUE;
		}

		if (!(object instanceof Entidade) || object.getClass() != this.getClass()) {
			return Boolean.FALSE;
		}
		final Entidade entidade = (Entidade) object;
		return (!Objects.isNull(entidade.getId()) && !Objects.isNull(this.getId()))
				? StringUtils.pathEquals(this.getId().toString(), entidade.getId().toString())
				: StringUtils.pathEquals(this.getUuid(), entidade.getUuid());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}

}
