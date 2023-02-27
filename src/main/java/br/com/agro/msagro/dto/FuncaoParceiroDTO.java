package br.com.agro.msagro.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.agro.msagro.entity.FuncaoParceiro;
import br.com.agro.msagro.enums.TipoParceiroEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FuncaoParceiroDTO extends EntidadeAmbienteDTO {

	private TipoParceiroEnum tipoParceiro;

	private ParceiroDTO parceiroDTO;

	private boolean sincronizado;

	private String codParceiro;

	private String descFuncaoParceiro;

	public FuncaoParceiro toEntity() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		return mapper.convertValue(this, new TypeReference<FuncaoParceiro>() {});
	}

}
