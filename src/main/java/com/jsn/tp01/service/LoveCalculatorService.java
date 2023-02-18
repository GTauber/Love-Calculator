package com.jsn.tp01.service;

import com.jsn.tp01.model.entity.LoveCalculator;
import reactor.core.publisher.Mono;

public interface LoveCalculatorService {

    Mono<LoveCalculator> calculateLove(String fname, String sname);

}
