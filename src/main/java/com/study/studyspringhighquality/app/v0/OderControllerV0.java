package com.study.studyspringhighquality.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OderControllerV0 {

    private final OderSerivceV0 oderSerivceV0;

    @GetMapping("/v0/request")
    public String request(String itemId){
        oderSerivceV0.orderItem(itemId);
        return "ok";
    }
}
