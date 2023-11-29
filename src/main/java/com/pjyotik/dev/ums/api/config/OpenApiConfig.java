package com.pjyotik.dev.ums.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Pranob Kalita",
                        email = "pranob.kalita90@gmail.com",
                        url = "https://pranobkalita.com"
                ),
                description = "OpenApi documentation for Spring Security Demo Project",
                title = "OpenApi specification - Pranob Kalita",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://pranobkalita.com"
                )
        }
)
public class OpenApiConfig {
}
