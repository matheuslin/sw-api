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

		// fetches the planets from SWAPI
		System.out.println("Populating Database with SWAPI Planets");
		swWebClient.populateSWPlanets();

		// create a new planet
		System.out.println("\n\n--[A new Planet]--");
		Planet p = new Planet();
		p.setName("AME");
		p.setClimate("very pleasant");
		p.setTerrain("cityscape");
		p.setFilmCount(0);
		System.out.println(swWebClient.insertPlanet(p));


		// get all planets list
		System.out.println("\n\n--[All Planets]--");
		System.out.println(swWebClient.getPlanetList());

		// get only planets with a SWID (from SWAPI)
		System.out.println("\n\n--[All Planets with a SWID (from SWAPI)]--");
		System.out.println(swWebClient.getSwPlanets());
	}
}