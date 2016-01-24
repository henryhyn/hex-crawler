package com.nengjun.hex.crawler.parser;

import com.nengjun.hex.crawler.Page;
import com.nengjun.hex.crawler.UrlPattern;
import com.nengjun.hex.crawler.Request;

import java.util.HashSet;
import java.util.regex.Matcher;

/**
 * Created by Henry on 16/1/23.
 */
public class UrlParser implements Parser {
    private UrlPattern[] urlPatterns;

    public UrlParser(UrlPattern... urlPatterns) {
        this.urlPatterns = urlPatterns;
    }

    public void parse(Page page) {
        if (page == null) {
            return;
        }

        page.setNewRequests(new HashSet<Request>());
        for (UrlPattern urlPattern : urlPatterns) {
            Matcher m = urlPattern.getPattern().matcher(page.getHtml());
            while (m.find()) {
                String url = String.format(urlPattern.getRepexp(), m.group(1));
                page.getNewRequests().add(new Request(page.getRequest().getSource(), url));
            }
        }
    }
}
