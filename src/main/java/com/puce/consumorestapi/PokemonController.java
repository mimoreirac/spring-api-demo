package com.puce.consumorestapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pokemon/v1")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/random")
    public Pokemon fetchRandomPokemon() {
        return pokemonService.fetchAndSaveRandomPokemon();
    }

    @PostMapping("/fetch/{id}")
    public Pokemon fetchAndSave(@PathVariable int id) {
        return pokemonService.fetchAndSavePokemon(id);
    }

    @GetMapping("/{id}")
    public Pokemon getFromDatabase(@PathVariable int id) {
        return pokemonService.getPokemonFromDb(id);
    }
}
