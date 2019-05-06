package br.com.perguntadodia.swapi.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class SWWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");

    public String getPlanetList(){
        Mono<ClientResponse> result = client.get()
            .uri("planets")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();
        
            return result.flatMap( res -> res.bodyToMono(String.class)).block();
    }
}