package br.com.perguntadodia.swapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  public void contextLoads() {

  }

  // @Test
  // public void testGetAllPlanets(){

  //   String expectedJson = "[{\"id\":1,\"swid\":null,\"name\":\"Earth\",\"climate\":null,\"terrain\":null,\"filmCount\":null},{\"id\":2,\"swid\":1,\"name\":\"Tatooine\",\"climate\":null,\"terrain\":null,\"filmCount\":null},{\"id\":3,\"swid\":null,\"name\":\"Terralissio\",\"climate\":null,\"terrain\":null,\"filmCount\":null},{\"id\":4,\"swid\":null,\"name\":\"Talos IV\",\"climate\":null,\"terrain\":null,\"filmCount\":null}]";

  //   webTestClient
  //     .get().uri("/planets")
  //     .accept(MediaType.TEXT_EVENT_STREAM, MediaType.APPLICATION_JSON_UTF8)
  //     .exchange()
  //     .expectStatus().isOk()
  //     .expectBody().json(expectedJson);
  // }

  // @Test
  // public void testGetOnePlanetById(){
  //   String expectedJson = "{\"id\":3,\"swid\":null,\"name\":\"Terralissio\",\"climate\":null,\"terrain\":null,\"filmCount\":null}";

  //   webTestClient
  //     .get().uri("/planets/id/3")
  //     .accept(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON_UTF8)
  //     .exchange()
  //     .expectStatus().isOk()
  //     .expectBody().json(expectedJson);
  // }

  // @Test
  // public void testGetOnePlanetByName(){
  //   String expectedJson = "{\"id\":1,\"swid\":null,\"name\":\"Earth\",\"climate\":null,\"terrain\":null,\"filmCount\":null}";
  //   webTestClient
  //     .get().uri("/planets/name/Earth")
  //     .accept(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON_UTF8)
  //     .exchange()
  //     .expectStatus().isOk()
  //     .expectBody().json(expectedJson);
  // }

  // @Test
  // public void testGetSwPlanets(){
  //   String expectedJson = "[{\"id\":2,\"swid\":1,\"name\":\"Tatooine\",\"climate\":null,\"terrain\":null,\"filmCount\":null}]";
  //   webTestClient
  //     .get().uri("/planets/swid")
  //     .accept(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON_UTF8)
  //     .exchange()
  //     .expectStatus().isOk()
  //     .expectBody().json(expectedJson);
  // }
}