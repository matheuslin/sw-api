package br.com.perguntadodia.swapi.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import br.com.perguntadodia.swapi.handler.PlanetHandler;

@Configuration
@EnableWebFlux
public class WebConfig implements WebFluxConfigurer {

  @Bean
  public RouterFunction<ServerResponse> routeShow(PlanetHandler planetHandler) {
    return RouterFunctions
      .route(   RequestPredicates.GET("/planets/id/{id}"), planetHandler::byId)
      .andRoute(RequestPredicates.GET("/planets/name/{name}"), planetHandler::byName)
      .andRoute(RequestPredicates.GET("/planets/swid"), planetHandler::allSw)
      .andRoute(RequestPredicates.GET("/planets"), planetHandler::all)
      .andRoute(RequestPredicates.POST("/planets"), planetHandler::insertPlanet)
      .andRoute(RequestPredicates.DELETE("/planets/id/{id}"), planetHandler::delete)
      ;
  }
}