package com.deerufin.keelungsightsviewer_ver4.service;

import jakarta.annotation.PostConstruct;
import com.deerufin.keelungsightsviewer_ver4.entity.Sight;
import com.deerufin.keelungsightsviewer_ver4.model.KeelungSightsCrawler;
import com.deerufin.keelungsightsviewer_ver4.repository.SightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class SightService {
    final private SightRepository sightRepository;
    @Autowired
    public SightService(SightRepository sightRepository) {
        this.sightRepository = sightRepository;
    }
    public List<Sight> getSightByZone(String zone){
        return sightRepository.findByZone(zone);
    }

//    @PostConstruct
//    public void init() throws IOException {
//        sightRepository.deleteAll();
//        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
//        for(Sight sight: crawler.getAllSights()){
//            if(sight.getPhotoURL()==null)sight.setPhotoURL("https://anon-tokyo.com/image?frame=27448&episode=1-3");
//            sightRepository.insert(sight);
//        }
//    }

    public void deleteAll(){
        sightRepository.deleteAll();
    }
}
