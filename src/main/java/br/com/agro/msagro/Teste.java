package br.com.agro.msagro;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Teste {

	public static void main(String[] args) {
		System.out.print(new BCryptPasswordEncoder().encode("Alvorada@1234"));
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			System.out.println(mapper.writeValueAsString(TipoPessoaEnum.PJ));
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
