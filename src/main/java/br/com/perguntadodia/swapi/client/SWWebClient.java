package br.com.perguntadodia.swapi.client;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.perguntadodia.swapi.model.Planet;
import br.com.perguntadodia.swapi.model.SWPlanet;
import br.com.perguntadodia.swapi.model.SWPlanetList;
import reactor.core.publisher.Mono;

public class SWWebClient {
    private WebClient client = WebClient.create("http://localhost:8080");
    WebClient swClient = WebClient.create();

    public void populateSWPlanets(){
        fetchSWPlanetsPage("https://swapi.co/api/planets/?format=json");
    }

    private void fetchSWPlanetsPage(String url){
        Mono<ClientResponse> result = swClient.get()
            .uri(url)
            .accept(MediaType.APPLICATION_JSON)
            .exchange();
        
        SWPlanetList swPlanetList = result.flatMap(res -> res.bodyToMono(SWPlanetList.class)).block();

        for(SWPlanet swPlanet : swPlanetList.getResults()){
            this.insertPlanet(Planet.fromSWPlanet(swPlanet));
        }

        if(swPlanetList.getNext() != null){
            fetchSWPlanetsPage(swPlanetList.getNext());
        }
    }

    public String getPlanetList(){
        Mono<ClientResponse> result = client.get()
            .uri("planets")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();
        
            return result.flatMap( res -> res.bodyToMono(String.class)).block();
    }

    public String getSwPlanets(){
        Mono<ClientResponse> result = client.get()
            .uri("planets/swid")
            .accept(MediaType.TEXT_PLAIN)
            .exchange();
        
            return result.flatMap( res -> res.bodyToMono(String.class)).block();
    }

    public String insertPlanet(Planet p){
        Mono<ClientResponse> result = client.post()
            .uri("planets")
            .body(Mono.just(p), Planet.class)
            .accept(MediaType.APPLICATION_JSON)
            .exchange();
        return result.flatMap( res -> res.bodyToMono(String.class)).block();
    }
}