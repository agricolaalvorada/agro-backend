package br.com.agro.msagro.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.agro.msagro.entity.Tag;


@FeignClient(name = "automacao", url = "http://localhost:8082")
public interface AutomacaoClientWS {
	
	@RequestMapping(method = RequestMethod.POST, value = "/automacao/tag/add", consumes = "application/json")
    Tag salvarTag(Tag tag) ;

}
