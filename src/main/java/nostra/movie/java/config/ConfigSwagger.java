package nostra.movie.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class ConfigSwagger {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Yose").apiInfo(apiInfo()).select()
                .paths(regex("/.*")).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Nostra")
                .description("Sample Documentation Generateed Using SWAGGER2 for our Movie Rest API")
                .license("Nostra").build();
    }
}
