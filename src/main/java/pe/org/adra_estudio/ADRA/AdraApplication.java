package pe.org.adra_estudio.ADRA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spi.DocumentationType;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;

@SpringBootApplication
@EnableSwagger2
public class AdraApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdraApplication.class, args);
	}
        
        @Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("pe.org.adra_estudio.ADRA")).build();
	}

}
