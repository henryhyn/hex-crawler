package com.nengjun.hex.crawler.scheduler;

import com.nengjun.hex.crawler.Request;
import com.nengjun.hex.crawler.mapper.RequestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by Henry on 16/1/24.
 */
@Service("mySQLScheduler")
public class MySQLScheduler implements Scheduler {
    private String source;

    @Resource
    RequestMapper requestMapper;

    public boolean hasNext() {
        Request req = requestMapper.selectNewUrl(source);
        return req != null;
    }

    public void push(Request request) {
        if (request == null) {
            return;
        }
        source = request.getSource();
        Request req = requestMapper.selectByUrl(request.getUrl());
        if (req == null) {
            requestMapper.insertSelective(request);
        }
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
        Request req = requestMapper.selectNewUrl(source);
        req.setStatus((byte) 1);
        requestMapper.updateByPrimaryKeySelective(req);
        return req;
    }

    public void update(Request request) {
        requestMapper.updateByPrimaryKeySelective(request);
    }
}
