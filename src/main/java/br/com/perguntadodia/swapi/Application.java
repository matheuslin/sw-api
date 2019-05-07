package br.com.perguntadodia.swapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.perguntadodia.swapi.client.SWWebClient;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		SWWebClient swWebClient = new SWWebClient();
		System.out.println(swWebClient.getPlanetList());
		System.out.println(swWebClient.getSwPlanets());
	}
}