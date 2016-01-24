package com.nengjun.hex.crawler.model;

import com.nengjun.hex.crawler.UrlPattern;
import com.nengjun.hex.crawler.Spider;
import com.nengjun.hex.crawler.downloader.HttpClientDownloader;
import com.nengjun.hex.crawler.outputer.FileOutputer;
import com.nengjun.hex.crawler.parser.UrlParser;
import com.nengjun.hex.crawler.scheduler.MySQLScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Henry on 16/1/23.
 */
public class Paizi {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config/spring/local/appcontext-*.xml");
        MySQLScheduler scheduler = (MySQLScheduler) context.getBean("mySQLScheduler");
        UrlPattern targetUrl = new UrlPattern("(dp\\d+)", "http://i.paizi.com/%s");
        UrlPattern helpUrl = new UrlPattern("(dp-\\w+(-\\d+)?)", "http://i.paizi.com/%s");
        Spider.create()
                .setSource("Paizi")
                .setScheduler(scheduler)
                .setDownloader(new HttpClientDownloader())
                .setOutputer(new FileOutputer("Paizi"))
                .setParser(new UrlParser(targetUrl, helpUrl))
                .addUrl("http://i.paizi.com")
                .run();
        System.exit(0);
    }
}
