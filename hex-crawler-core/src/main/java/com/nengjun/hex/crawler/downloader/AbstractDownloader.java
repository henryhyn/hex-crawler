package com.nengjun.hex.crawler.downloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Henry on 16/1/23.
 */
public abstract class AbstractDownloader implements Downloader {
    protected Logger logger = LoggerFactory.getLogger(getClass());
}
