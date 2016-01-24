package com.nengjun.hex.crawler.downloader;

import com.nengjun.hex.crawler.Page;
import com.nengjun.hex.crawler.Request;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Henry on 16/1/23.
 */
public class HttpClientDownloader extends AbstractDownloader {
    public Page download(Request request) {
        if (request == null) {
            return null;
        }

        HttpGet httpGet = new HttpGet(request.getUrl());

        Page page = new Page();
        page.setRequest(request);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            Long t = new Date().getTime();
            CloseableHttpResponse response = httpClient.execute(httpGet);
            logger.info("cost {} milliseconds.", new Date().getTime() - t);
            try {
                page.setStatusCode(response.getStatusLine().getStatusCode());
                page.setHtml(EntityUtils.toString(response.getEntity()));
            } catch (IOException e) {
                logger.error("Input & Output error.", e);
            } finally {
                try {
                    response.close();
                } catch (IOException e) {
                    logger.error("Input & Output error.", e);
                }
            }
        } catch (ClientProtocolException e) {
            logger.error("Client protocol error.", e);
        } catch (IOException e) {
            logger.error("Input & Output error.", e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                logger.error("Input & Output error.", e);
            }
        }

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
