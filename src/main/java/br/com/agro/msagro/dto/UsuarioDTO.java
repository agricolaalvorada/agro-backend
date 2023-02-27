package br.com.agro.msagro.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.entity.Usuario;
import br.com.agro.msagro.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioDTO extends EntidadeAmbienteDTO {

	private String nome;

	private String codigo;

	private String cpf;

	private String login;

	private StatusEnum status;
	
	public Usuario toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(this, new TypeReference<Usuario>() {});
	}
	
}
