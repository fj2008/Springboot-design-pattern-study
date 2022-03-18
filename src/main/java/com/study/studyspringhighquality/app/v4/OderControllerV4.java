package com.study.studyspringhighquality.app.v4;

import com.study.studyspringhighquality.trace.TraceStatus;
import com.study.studyspringhighquality.trace.logtrace.LogTrace;
import com.study.studyspringhighquality.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OderControllerV4 {

    private final OderSerivceV4 oderSerivce;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId){

        AbstractTemplate<String> template = new AbstractTemplate<String>(trace) {
            @Override
            protected String call() {
                oderSerivce.orderItem(itemId);
                return "ok";

            }
        };
        return  template.execute("OrderControoller.request()");
    }
}
