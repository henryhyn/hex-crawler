package com.nengjun.hex.crawler;

import com.nengjun.hex.crawler.downloader.Downloader;
import com.nengjun.hex.crawler.outputer.Outputer;
import com.nengjun.hex.crawler.parser.Parser;
import com.nengjun.hex.crawler.scheduler.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Henry on 16/1/23.
 */
public class Spider {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String source;
    private Scheduler scheduler;
    private Downloader downloader;
    private Outputer outputer;
    private Parser parser;

    public static Spider create() {
        return new Spider();
    }

    public void run() {
        int num = 0;
        while (scheduler.hasNext()) {
            num += 1;
            Request request = scheduler.poll();
            logger.info("craw {}: {}", num, request.getUrl());
            Page page = downloader.download(request);
            scheduler.update(request);
            if (request.getStatus() == -1) {
                logger.info("craw failed: {}", request.getUrl());
                continue;
            }
            outputer.process(page);
            parser.parse(page);
            scheduler.push(page.getNewRequests());
        }
    }

    public Spider addUrl(String url) {
        scheduler.push(new Request(source.toUpperCase(), url));
        return this;
    }

    public Spider setSource(String source) {
        this.source = source;
        return this;
    }

    public Spider setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
        return this;
    }

    public Spider setDownloader(Downloader downloader) {
        this.downloader = downloader;
        return this;
    }

    public Spider setOutputer(Outputer outputer) {
        this.outputer = outputer;
        return this;
    }

    public Spider setParser(Parser parser) {
        this.parser = parser;
        return this;
    }
}
