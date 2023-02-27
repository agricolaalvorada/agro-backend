package br.com.agro.msagro.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeAmbiente extends Entidade {

    private static final long serialVersionUID = 2325166658203959465L;

    @Column(name = "id_ambiente")
    private Long idAmbiente;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @Column(name = "data_hora_cadastro", updatable = false, insertable = true)
    private LocalDateTime dataHoraCadastro;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(this.getId()) || this.getId() == 0 ) {
            this.dataHoraCadastro = LocalDateTime.now();
        }
    }


}
