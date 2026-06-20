package com.mybankms.accounts;

import com.mybankms.accounts.DTO.AccountsContactInfoDTO;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDTO.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                version = "v1",
                description = "EasyBank Accounts microservice REST API documentation for managing customer accounts, including account creation, retrieval, and deletion operations.",
                contact= @Contact(
                        name = "Priti Patankar",
                        email = "priti2001@gmail.com",
                        url = "www.linkedin.com/in/priti-patankar"
                        ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "EazyBank Accounts microservice Rest API Documentation",
                url = "http://www.eazybank.com/swagger-ui.html"
        )
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
