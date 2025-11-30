package com.puce.consumorestapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Random;

@Service
public class PokemonService {

    private final RestClient restClient;
    private final PokemonRepository pokemonRepository;
    private final Random random;

    public PokemonService(RestClient restClient, PokemonRepository pokemonRepository) {
        this.restClient = restClient;
        this.pokemonRepository = pokemonRepository;
        this.random = new Random();
    }

    public Pokemon fetchAndSavePokemon(int id) {
        Pokemon pokemon = restClient.get()
                .uri("/pokemon/{id}", id)
                .retrieve()
                .body(Pokemon.class);

        if (pokemon == null) {
            throw new RuntimeException("Pokemon not found with id: " + id);
        }

        return pokemonRepository.save(pokemon);
    }

    public Pokemon fetchAndSaveRandomPokemon() {
        int randomId = random.nextInt(1328) + 1;
        return fetchAndSavePokemon(randomId);
    }

    public Pokemon getPokemonFromDb(int id) {
        return pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon not found"));
    }
}
