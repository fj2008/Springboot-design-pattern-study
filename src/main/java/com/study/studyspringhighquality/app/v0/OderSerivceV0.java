package com.study.studyspringhighquality.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OderSerivceV0 {
    private final OrderRepositoryV0 orderRepositoryV0;

    public void orderItem(String itemId){
        orderRepositoryV0.save(itemId);
    }
}
