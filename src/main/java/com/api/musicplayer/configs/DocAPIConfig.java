package com.api.musicplayer.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DocAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Server localServer = new Server();
        localServer.setDescription("Server URL in Local environment");

        Info info = new Info()
                .title("API Music Player")
                .version("1.0")
                .description("Esta API disponibiliza endPoint para o gerenciamento de musicas.");

        return new OpenAPI()
                .info(info)
                .servers(List.of(localServer));
    }

}
