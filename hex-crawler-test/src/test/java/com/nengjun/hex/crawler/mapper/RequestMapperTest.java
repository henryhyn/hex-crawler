package com.nengjun.hex.crawler.mapper;

import com.nengjun.hex.crawler.AbstractTest;
import com.nengjun.hex.crawler.Request;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Henry on 16/1/24.
 */
public class RequestMapperTest extends AbstractTest {
    @Resource
    RequestMapper requestMapper;

    @Test
    public void test() {
        Request request = requestMapper.selectByPrimaryKey(1);
        System.out.println(request);
        System.out.println("Hello world!");
    }
}
