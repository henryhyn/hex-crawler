package com.nengjun.hex.crawler.model;

import com.nengjun.hex.crawler.UrlPattern;
import com.nengjun.hex.crawler.Spider;
import com.nengjun.hex.crawler.downloader.SeleniumDownloader;
import com.nengjun.hex.crawler.outputer.FileOutputer;
import com.nengjun.hex.crawler.parser.UrlParser;
import com.nengjun.hex.crawler.scheduler.MySQLScheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Henry on 16/1/24.
 */
public class TmallBrand {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config/spring/local/appcontext-*.xml");
        MySQLScheduler scheduler = (MySQLScheduler) context.getBean("mySQLScheduler");
        UrlPattern targetUrl = new UrlPattern("brandId\\s*=.*?(\\d+)", "https://brand.tmall.com/brandInfo.html?brandId=%s");
        Spider.create()
                .setSource("Tmall_Brand")
                .setScheduler(scheduler)
                .setDownloader(new SeleniumDownloader())
                .setOutputer(new FileOutputer("Tmall_Brand"))
                .setParser(new UrlParser(targetUrl))
                .addUrl("https://brand.tmall.com/brandMap.htm")
                .run();
        System.exit(0);
    }
}
