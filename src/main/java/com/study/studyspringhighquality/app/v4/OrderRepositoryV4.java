package com.study.studyspringhighquality.app.v4;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.logtrace.LogTrace;
import com.study.studyspringhighquality.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class OrderRepositoryV4 {
    private final LogTrace trace;
    public void save( String itemId){


        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                if(itemId.equals("ex")){
                    throw new IllegalStateException("예외 발생!");
                }
                sleep(100);
                return null;
            }
        };
        template.execute("OrderRepositoryV1.save()");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
