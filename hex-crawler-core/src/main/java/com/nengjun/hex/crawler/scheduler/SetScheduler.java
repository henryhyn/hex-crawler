package com.nengjun.hex.crawler.scheduler;

import com.nengjun.hex.crawler.Request;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Henry on 16/1/23.
 */
public class SetScheduler implements Scheduler {
    private Set<Request> oldUrls;
    private Set<Request> newUrls;

    public SetScheduler() {
        oldUrls = new HashSet<Request>();
        newUrls = new HashSet<Request>();
    }

    public boolean hasNext() {
        return newUrls.iterator().hasNext();
    }

    public void push(Request request) {
        if (request == null) {
            return;
        }
        if (oldUrls.contains(request) || newUrls.contains(request)) {
            return;
        }
        newUrls.add(request);
    }

    public void push(Set<Request> requests) {
        if (requests == null) {
            return;
        }
        for (Request request : requests) {
            push(request);
        }
    }

    public Request poll() {
        return newUrls.iterator().next();
    }

    public void update(Request request) {
        newUrls.remove(request);
        oldUrls.add(request);
    }
}
