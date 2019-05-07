package br.com.perguntadodia.swapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.perguntadodia.swapi.model.Planet;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void contextLoads() {

  }

  @Test
  public void planetsIsOkTest() {
    webTestClient.get().uri("/planets").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk();
  }

  public void savePlanetTest() {
    Planet p = new Planet();
    p.setName("Test Planet 1");
    p.setClimate("No atmosphere");
    p.setTerrain("rocky");
    p.setFilmCount(0);

    webTestClient
      .post()
      .uri("planets")
      .body(Mono.just(p), Planet.class)
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isOk().expectBody(Planet.class);
  }
}