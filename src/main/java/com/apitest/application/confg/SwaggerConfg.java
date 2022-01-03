package com.apitest.application.confg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
		 info = @Info(
	               title = "Api Test Service",
	               version = "v2",
		       description = "Test External Api Calls",
		       contact = @Contact(
					name = "Ojo Gideon .O",
					email = "gojo@atbtechsoft.com"
				)
			),
	     
	     servers = {
	            @Server( 
	               url="https://api-test.notchcx.io/apicallservice",
	               description="Test Server"
	            ),
	            @Server( 
	 	               url="http://10.10.100.178:8080/apicallservice",
	 	               description="local"
	 	            )
	     }
	)
public class SwaggerConfg {
	@Bean
	  public OpenAPI peopleServiceOpenAPI() {
	    return (new OpenAPI())
	      .components((new Components()).addSecuritySchemes("apiKeyScheme", (new SecurityScheme())
	          .type(SecurityScheme.Type.APIKEY)
	          .in(SecurityScheme.In.HEADER)
	          .name("Authorization")))
	      
	      .addSecurityItem((new SecurityRequirement()).addList("apiKeyScheme"));
	  }
}
