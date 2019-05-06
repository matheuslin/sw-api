package br.com.perguntadodia.swapi.repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.reactivestreams.Publisher;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.perguntadodia.swapi.model.Planet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ReactivePlanetRepository implements ReactiveCrudRepository<Planet, String> {

    private final Map<Integer, Planet> planetMap = new ConcurrentHashMap<Integer, Planet>();

    public ReactivePlanetRepository(){
        super();
        planetMap.put(1, new Planet(1, "Earth"));
        planetMap.put(2, new Planet(2, "Tatooine"));
        planetMap.put(3, new Planet(3, "Terralissio"));
        planetMap.put(4, new Planet(4, "Talos IV"));
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
    public Mono<Void> deleteById(String arg0) {
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
    public Flux<Planet> findAll() {
        return Flux.fromIterable(planetMap.values());
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
    public Mono<Planet> findById(String arg0) {
        return null;
    }

    @Override
    public Mono<Planet> findById(Publisher<String> arg0) {
        return null;
    }

    @Override
    public <S extends Planet> Mono<S> save(S arg0) {
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