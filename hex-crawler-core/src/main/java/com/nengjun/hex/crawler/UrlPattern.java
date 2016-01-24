package com.nengjun.hex.crawler;

import java.util.regex.Pattern;

/**
 * Created by Henry on 16/1/24.
 */
public class UrlPattern {
    private String regexp;
    private String repexp;
    private Pattern pattern;

    public UrlPattern(String regexp, String repexp) {
        this.regexp = regexp;
        this.repexp = repexp;
        this.pattern = Pattern.compile(regexp);
    }

    public String getRegexp() {
        return regexp;
    }

    public String getRepexp() {
        return repexp;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
