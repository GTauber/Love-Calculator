package com.jsn.tp01.service.impl;

import com.jsn.tp01.model.entity.LoveCalculator;
import com.jsn.tp01.service.LoveCalculatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class LoveCalculatorServiceImpl implements LoveCalculatorService {

    private final WebClient webClient;

    public LoveCalculatorServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://love-calculator.p.rapidapi.com")
            .defaultHeader("X-RapidAPI-Host", "love-calculator.p.rapidapi.com")
            .defaultHeader("X-RapidAPI-Key", "51fe449fa1msh863755c0321108bp1c3adejsnc1f465b1bf3b")
            .build();
    }

    @Override
    public Mono<LoveCalculator> calculateLove(String sname, String fname) {

        return webClient.get()
            .uri(uriBuilder -> uriBuilder.path("/getPercentage")
                .queryParam("fname", fname)
                .queryParam("sname", sname)
                .build())
            .retrieve()
            .bodyToMono(LoveCalculator.class).log();
    }
}
