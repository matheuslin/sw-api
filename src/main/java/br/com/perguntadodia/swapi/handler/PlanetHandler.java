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
    Flux<Planet> shows = this.planetRepository.findAll();
    return ServerResponse.ok().body(shows, Planet.class);
  }
  
}