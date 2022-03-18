package com.study.studyspringhighquality.app.v2;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.hellotrace.HelloTraceV1;
import com.study.studyspringhighquality.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OderControllerV2 {

    private final OderSerivceV2 oderSerivce;
    private final HelloTraceV2 trace;

    @GetMapping("/v2/request")
    public String request(String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderControoller.request()");
            oderSerivce.orderItem(status.getTraceId(),itemId);//예외가터지면 end를 타지 못한다.
            trace.end(status);
            return "ok";

        }catch (Exception e){
            trace.exception(status, e); //여기서 예외를 먹기때문에
            throw e; //예외를 꼭 다시 던저주어야 한다.
        }
    }
}
