package com.nengjun.hex.crawler.outputer;

import com.nengjun.hex.crawler.Page;

/**
 * Created by Henry on 16/1/23.
 */
public class ConsoleOutputer implements Outputer {
    public void process(Page page) {
        System.out.println(page);
    }
}
