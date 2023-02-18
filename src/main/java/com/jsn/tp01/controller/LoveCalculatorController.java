package com.jsn.tp01.controller;

import com.jsn.tp01.model.entity.LoveCalculator;
import com.jsn.tp01.service.LoveCalculatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/love-calculator")
@AllArgsConstructor
@Slf4j
public class LoveCalculatorController {


    private final LoveCalculatorService loveCalculatorService;

    @GetMapping("/calculate")
    public Mono<LoveCalculator> calculateLove(@RequestParam String fname, @RequestParam String sname) {
        log.info("Calculating love between {} and {}", fname, sname);
        return loveCalculatorService.calculateLove(fname, sname).doOnNext(loveCalculator -> log.info("Love calculated: {}", loveCalculator));
    }

}
