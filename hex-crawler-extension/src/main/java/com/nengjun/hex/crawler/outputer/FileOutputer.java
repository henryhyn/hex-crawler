package com.nengjun.hex.crawler.outputer;

import com.nengjun.hex.crawler.Page;

import java.io.*;

/**
 * Created by Henry on 16/1/23.
 */
public class FileOutputer implements Outputer {
    private File path;

    public FileOutputer(String dir) {
        path = new File("/data/crawler", dir.toLowerCase());
        if (!path.exists()) {
            path.mkdirs();
        }
    }

    public void process(Page page) {
        File file = new File(path, page.getFileName());
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.println(page.getHtml());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
