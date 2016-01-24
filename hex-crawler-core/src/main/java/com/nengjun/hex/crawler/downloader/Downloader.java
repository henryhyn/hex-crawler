package com.nengjun.hex.crawler.downloader;

import com.nengjun.hex.crawler.Page;
import com.nengjun.hex.crawler.Request;

/**
 * Created by Henry on 16/1/23.
 */
public interface Downloader {
    Page download(Request request);
}
