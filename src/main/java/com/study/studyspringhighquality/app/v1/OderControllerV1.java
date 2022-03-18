package com.study.studyspringhighquality.app.v1;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OderControllerV1 {

    private final OderSerivceV1 oderSerivceV0;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderControoller.request()");
            oderSerivceV0.orderItem(itemId);//예외가터지면 end를 타지 못한다.
            trace.end(status);
            return "ok";

        }catch (Exception e){
            trace.exception(status, e); //여기서 예외를 먹기때문에
            throw e; //예외를 꼭 다시 던저주어야 한다.
        }
    }
}
