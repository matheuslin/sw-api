package br.com.perguntadodia.swapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.perguntadodia.swapi.client.SWWebClient;
import br.com.perguntadodia.swapi.model.Planet;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		SWWebClient swWebClient = new SWWebClient();
		System.out.println(swWebClient.getPlanetList());
		System.out.println(swWebClient.getSwPlanets());

		Planet p = new Planet(37, "Jupyter");
		p.setClimate("All of them");
		System.out.println(swWebClient.insertPlanet(p));

		System.out.println(swWebClient.getPlanetList());
	}
}