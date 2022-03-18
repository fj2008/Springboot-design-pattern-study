package com.study.studyspringhighquality.app.v1;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OderSerivceV1 {
    private final OrderRepositoryV1 orderRepositoryV0;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepositoryV0.save(itemId);//예외가터지면 end를 타지 못한다.
            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e); //여기서 예외를 먹기때문에
            throw e; //예외를 꼭 다시 던저주어야 한다.
        }

    }
}
