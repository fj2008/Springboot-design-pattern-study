package com.study.studyspringhighquality.app.v3;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV3 {
    private final LogTrace trace;
    public void save( String itemId){

        TraceStatus status = null;

        try{
            status = trace.begin("OrderRepositoryV1.save()");
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생!");

            }
            sleep(100);
            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e); //여기서 예외를 먹기때문에
            throw e; //예외를 꼭 다시 던저주어야 한다.
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
