package com.study.studyspringhighquality.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV0 {

    public void save(String itemId){
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생!");

        }
        sleep(100);
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
