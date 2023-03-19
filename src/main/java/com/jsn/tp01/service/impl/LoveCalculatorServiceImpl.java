package com.jsn.tp01.service.impl;

import com.jsn.tp01.model.entity.LoveCalculator;
import com.jsn.tp01.service.LoveCalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class LoveCalculatorServiceImpl implements LoveCalculatorService {

    private final WebClient webClient;

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
