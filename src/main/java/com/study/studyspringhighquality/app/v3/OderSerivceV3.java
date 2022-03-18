package com.study.studyspringhighquality.app.v3;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OderSerivceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;

    public void orderItem( String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);//예외가터지면 end를 타지 못한다.
            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e); //여기서 예외를 먹기때문에
            throw e; //예외를 꼭 다시 던저주어야 한다.
        }

    }
}
