package com.study.studyspringhighquality;

import com.study.studyspringhighquality.trace.logtrace.FieldLogTrace;
import com.study.studyspringhighquality.trace.logtrace.LogTrace;
import com.study.studyspringhighquality.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {
    //스프링 빈에 등록
    //리턴값으로 FieldLogTrace 빈에 싱글톤으로 등록
    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
