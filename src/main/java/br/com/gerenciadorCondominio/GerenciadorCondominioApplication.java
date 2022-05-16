package br.com.gerenciadorCondominio;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GerenciadorCondominioApplication {

    @Bean
    public ModelMapper modelMapper (){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(GerenciadorCondominioApplication.class, args);
    }

}
