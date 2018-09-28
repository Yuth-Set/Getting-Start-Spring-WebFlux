package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GameController {

	private Map<Integer, Game> games = new HashMap<Integer, Game>() {{
		put(1, new Game("PUGB Mobile"));
		put(2, new Game("God of War"));
		put(3, new Game("Rule of Servival"));
	}};
	
	@GetMapping("/games")
	public Flux<Game> games() {
		return Flux.fromIterable(games.values());
	}
	
	@GetMapping("/games/{id}")
	public Mono<Game> gameById(@PathVariable Integer id) {
		return Mono.justOrEmpty(games.get(id));
	}
}
