package com.deerufin.keelungsightsviewer_ver4;

import com.deerufin.keelungsightsviewer_ver4.entity.Sight;
import com.deerufin.keelungsightsviewer_ver4.model.KeelungSightsCrawler;

import java.io.IOException;

public class KeelungSightsCrawlerTest {
    public static void main(String[] args) throws IOException {
//        System.out.println("hello world");
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight[] sights = crawler.getItemByZone("七堵區");
        for (Sight s: sights) {
            System.out.println(s);
        }
    }
}
