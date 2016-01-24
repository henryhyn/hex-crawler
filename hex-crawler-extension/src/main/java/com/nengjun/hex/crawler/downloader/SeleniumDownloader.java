package com.nengjun.hex.crawler.downloader;

import com.nengjun.hex.crawler.Page;
import com.nengjun.hex.crawler.Request;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Date;

/**
 * Created by Henry on 16/1/24.
 */
public class SeleniumDownloader extends AbstractDownloader {
    private WebDriver driver;

    public SeleniumDownloader() {
        DesiredCapabilities caps = DesiredCapabilities.phantomjs();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "javascriptEnabled", true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "loadImages", false);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_PAGE_SETTINGS_PREFIX + "resourceTimeout", 1000);
        driver = new PhantomJSDriver(caps);
    }

    public Page download(Request request) {
        Page page = new Page();
        Long t = new Date().getTime();
        driver.get(request.getUrl());
        logger.info("cost {} milliseconds.", new Date().getTime() - t);
        page.setRequest(request);
        page.setHtml(driver.getPageSource());
        page.setStatusCode(200);

        if (request.getNumber() == null) {
            request.setNumber((byte) 1);
        } else {
            request.setNumber((byte) (request.getNumber() + 1));
        }

        if (page.getStatusCode() == 200) {
            request.setStatus((byte) 2);
        } else {
            request.setStatus((byte) -1);
        }

        return page;
    }
}
