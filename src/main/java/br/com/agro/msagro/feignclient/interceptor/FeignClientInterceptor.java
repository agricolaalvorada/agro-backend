package br.com.agro.msagro.feignclient.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.agro.msagro.dto.RequestLoginAutomacaoDTO;
import br.com.agro.msagro.dto.ResponseSigninDTO;
import feign.RequestInterceptor;
import feign.RequestTemplate;


@Component
public class FeignClientInterceptor implements RequestInterceptor {

  private static final String AUTHORIZATION_HEADER="Authorization";
  private static final String TOKEN_TYPE = "Bearer";
  
  @Value("${app.agro.feign.automacao.username}")
  private String usernameAutomacao;
  
  @Value("${app.agro.feign.automacao.password}")
  private String passwordAutomacao;
  
  @Value("${app.agro.feign.automacao.url}")
  private String urlAutomacao;
  
  
  @Override
  public void apply(RequestTemplate requestTemplate) {
	  
	if(requestTemplate.request().requestTemplate().feignTarget().name().equals("automacao")) {
		String token = getToken();
		if(token != null && !token.trim().isEmpty())
			requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, token));
    }
  }
  
  
  private String getToken() {
	  RestTemplate restTemplate = new RestTemplate();
	  HttpEntity<RequestLoginAutomacaoDTO> request = new HttpEntity<RequestLoginAutomacaoDTO>(new RequestLoginAutomacaoDTO(passwordAutomacao, usernameAutomacao));
	  ResponseEntity<ResponseSigninDTO> response = restTemplate.postForEntity(urlAutomacao + "api/auth/signin", request, ResponseSigninDTO.class);
	  if(response.getStatusCode() == HttpStatus.OK) {
		  return response.getBody().getToken();
	  }
	  return "";
  }
}
