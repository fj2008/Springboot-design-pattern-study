package com.study.studyspringhighquality.app.v3;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OderControllerV3 {

    private final OderSerivceV3 oderSerivce;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderControoller.request()");
            oderSerivce.orderItem(itemId);//예외가터지면 end를 타지 못한다.
            trace.end(status);
            return "ok";

        }catch (Exception e){
            trace.exception(status, e); //여기서 예외를 먹기때문에
            throw e; //예외를 꼭 다시 던저주어야 한다.
        }
    }
}
