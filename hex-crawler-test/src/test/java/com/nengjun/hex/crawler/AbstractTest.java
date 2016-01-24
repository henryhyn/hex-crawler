package com.nengjun.hex.crawler;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Henry on 16/1/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:config/spring/local/appcontext-*.xml")
public abstract class AbstractTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
