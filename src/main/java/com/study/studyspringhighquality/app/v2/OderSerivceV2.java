package com.study.studyspringhighquality.app.v2;

import com.study.studyspringhighquality.trace.TraceId;
import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OderSerivceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId){

        TraceStatus status = null;

        try{
            status = trace.beginSync(traceId,"OrderService.orderItem()");
            orderRepository.save(status.getTraceId(),itemId);//예외가터지면 end를 타지 못한다.
            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e); //여기서 예외를 먹기때문에
            throw e; //예외를 꼭 다시 던저주어야 한다.
        }

    }
}
