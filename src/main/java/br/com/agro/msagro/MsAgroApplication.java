package br.com.agro.msagro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableFeignClients
@EnableSpringDataWebSupport
public class MsAgroApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsAgroApplication.class, args);
    }

}
