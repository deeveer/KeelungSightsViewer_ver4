package com.deerufin.keelungsightsviewer_ver4.controller;

import com.deerufin.keelungsightsviewer_ver4.entity.Sight;
import com.deerufin.keelungsightsviewer_ver4.model.KeelungSightsCrawler;
import com.deerufin.keelungsightsviewer_ver4.service.SightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class MainController {
    @Autowired
    final private SightService sightService;
    public MainController(SightService sightService) {
        this.sightService = sightService;
    }

    @GetMapping("/test")
    public ResponseEntity<Sight[]> test(
            @RequestParam(value = "SightAPI", required = true) String Zone
    ) throws IOException {
        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight[] sights = crawler.getItemByZone(Zone);
        if(sights == null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sights);
    }

    @GetMapping("/APIGetSight")
    public ResponseEntity<List<Sight>> APIGetSight(
            @RequestParam(value = "SightAPI", required = true) String Zone
    ) throws IOException {
        List<Sight> sights = sightService.getSightByZone(Zone);
        for(Sight sight : sights){
            if(sight.getPhotoURL().isEmpty())sight.setPhotoURL("https://anon-tokyo.com/image?frame=27448&episode=1-3");
        }
        if(sights.isEmpty())return ResponseEntity.notFound().build();
        return ResponseEntity.ok(sights);
    }

    @DeleteMapping("/clear")
    public String clearDatabase() {
        sightService.deleteAll();
        return "Database cleared";
    }
}
