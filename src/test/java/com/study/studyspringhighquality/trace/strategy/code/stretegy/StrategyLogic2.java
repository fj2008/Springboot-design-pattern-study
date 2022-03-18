package com.study.studyspringhighquality.trace.strategy.code.stretegy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic2 implements Strategy{
    @Override
    public void call() {
        log.info("변하는 로직 2");
    }
}
