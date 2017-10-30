package com.murkino.demoflux;

import java.time.Duration;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class CatController {

	@GetMapping("/cats/{id}")
	public Mono<Cat> getById(@PathVariable Long id) {
		Cat cat = new Cat(1L, "Natura Sanat Demi Murr", "ny 11");
		return Mono.just(cat);
	}

	@GetMapping(value = "/cats", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Cat> listenToAll() {
		Flux<Cat> catFlux = Flux.fromStream(Stream.generate(() -> new Cat(System.currentTimeMillis(),
				"nejm" + System.currentTimeMillis(), "color" + System.currentTimeMillis())));
		Flux<Long> durationFlux = Flux.interval(Duration.ofSeconds(1));
		return Flux.zip(catFlux, durationFlux).map(
				Tuple2::getT1
				);
	}

}
