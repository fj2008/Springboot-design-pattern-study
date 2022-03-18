package com.study.studyspringhighquality.trace.logtrace;

import com.study.studyspringhighquality.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);
    void exception(TraceStatus status, Exception e);
}
