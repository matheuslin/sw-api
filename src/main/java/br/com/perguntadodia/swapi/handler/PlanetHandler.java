package br.com.perguntadodia.swapi.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.perguntadodia.swapi.model.Planet;
import br.com.perguntadodia.swapi.repository.ReactivePlanetRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PlanetHandler {

  private final ReactivePlanetRepository planetRepository;

  public PlanetHandler(ReactivePlanetRepository planetRepository) {
    this.planetRepository = planetRepository;
  }

  public Mono<ServerResponse> all(ServerRequest serverRequest) {
    Flux<Planet> planets = this.planetRepository.findAll();
    return ServerResponse.ok().body(planets, Planet.class);
  }

  public Mono<ServerResponse> byId(ServerRequest serverRequest) {
    String id = serverRequest.pathVariable("id");
    Mono<Planet> planet = this.planetRepository.findById(id);  
    return ServerResponse.ok().body(planet, Planet.class);
  }

  public Mono<ServerResponse> byName(ServerRequest serverRequest){
    String name = serverRequest.pathVariable("name");
    Mono<Planet> planet = this.planetRepository.findByName(name);
    return ServerResponse.ok().body(planet, Planet.class);
  }

  public Mono<ServerResponse> allSw(ServerRequest serverRequest){
    Flux<Planet> planets = this.planetRepository.findAllSw();
    return ServerResponse.ok().body(planets, Planet.class);
  }
}