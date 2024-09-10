package com.deerufin.keelungsightsviewer_ver4.Initializer;

import com.deerufin.keelungsightsviewer_ver4.model.KeelungSightsCrawler;
import com.deerufin.keelungsightsviewer_ver4.repository.SightRepository;
import com.deerufin.keelungsightsviewer_ver4.entity.Sight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {

    @Autowired
    private SightRepository sightRepository;

    @Override
    public void run(ApplicationArguments args) throws IOException {
        sightRepository.deleteAll();
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        List<Sight> allSights = crawler.getAllSights();
        sightRepository.saveAll(allSights);
    }
}
