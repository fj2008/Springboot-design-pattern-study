package com.study.studyspringhighquality.trace.strategy.code.stretegy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
class ContextV2Test {

    @Test
    void strategyV1(){
        ContextV2 context1 = new ContextV2();
        context1.execute(new StrategyLogic1());
        context1.execute(new StrategyLogic2());

    }
    @Test
    void strategyV2(){
        ContextV2 context1 = new ContextV2();
        context1.execute(() -> {
            log.info("람다.");
        });
        context1.execute(() -> {
            log.info("람다1.");
        });

    }
}