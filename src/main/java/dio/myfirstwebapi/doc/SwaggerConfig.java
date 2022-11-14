package dio.myfirstwebapi.doc;


import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //INFORMAÇÕES DE CONTATO
    private Contact contact() {
        return new Contact(
                "Dionatan de Andrade",
                "https://www.linkedin.com/in/dionatandeandrade/",
                "dionatan.andrade@hotmail.com");
    }

    //INFORMAÇÕES SOBRE A API
    private ApiInfoBuilder infoApi(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Rest API");
        apiInfoBuilder.description("Exemplo de uso de Spring Boot com Swagger");
        apiInfoBuilder.version("1.00");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Dionatan®");
        apiInfoBuilder.licenseUrl("https://www.linkedin.com/in/dionatandeandrade/");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;
    }

    @Bean
    public Docket detailApi(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("dio.myfirstwebapi.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infoApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }

}
