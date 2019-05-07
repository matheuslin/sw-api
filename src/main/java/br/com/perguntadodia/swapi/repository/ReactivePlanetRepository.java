package br.com.perguntadodia.swapi.repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.perguntadodia.swapi.model.Planet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ReactivePlanetRepository implements ReactiveCrudRepository<Planet, String> {

    private final Map<UUID, Planet> planetMap = new ConcurrentHashMap<UUID, Planet>();

    public ReactivePlanetRepository() {
        super();

        // fill up with planets from SWAPI
    }

    public Mono<Planet> findByName(String name) {
        for (UUID id : planetMap.keySet()) {
            Planet p = planetMap.get(id);
            if (p.getName().equals(name)) {
                return Mono.just(p);
            }
        }
        return Mono.empty();
    }

    public Flux<Planet> findAllSw() {

        Collection<Planet> allPlanets = planetMap.values();
        Set<Planet> swPlanets = new HashSet<Planet>();
        for (Planet p : allPlanets) {
            if (p.getSwid() != null) {
                swPlanets.add(p);
            }
        }
        return Flux.fromIterable(swPlanets);
    }

    @Override
    public Flux<Planet> findAll() {
        return Flux.fromIterable(planetMap.values());
    }

    @Override
    public Mono<Planet> findById(String key) {
        return Mono.justOrEmpty(planetMap.get(UUID.fromString(key)));
    }

    @Override
    public Mono<Planet> save(Planet planet) {
        this.planetMap.put(planet.getId(), planet);
        return Mono.justOrEmpty(planetMap.get(planet.getId()));
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> delete(Planet arg0) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends Planet> arg0) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends Planet> arg0) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String idArg) {
        UUID id = UUID.fromString(idArg);
        Planet removed = this.planetMap.remove(id);
        if(removed != null){
            return Mono.empty();
        }
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> arg0) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String arg0) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> arg0) {
        return null;
    }

    @Override
    public Flux<Planet> findAllById(Iterable<String> arg0) {
        return null;
    }

    @Override
    public Flux<Planet> findAllById(Publisher<String> arg0) {
        return null;
    }

    @Override
    public Mono<Planet> findById(Publisher<String> arg0) {
        return null;
    }

    @Override
    public <S extends Planet> Flux<S> saveAll(Iterable<S> arg0) {
        return null;
    }

    @Override
    public <S extends Planet> Flux<S> saveAll(Publisher<S> arg0) {
        return null;
    }

    
    
}