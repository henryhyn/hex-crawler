package com.nengjun.hex.crawler.scheduler;

import com.nengjun.hex.crawler.Request;

import java.util.Set;

/**
 * Created by Henry on 16/1/23.
 */
public interface Scheduler {
    boolean hasNext();

    void push(Request request);

    void push(Set<Request> requests);

    Request poll();

    void update(Request request);
}
