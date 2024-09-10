package com.deerufin.keelungsightsviewer_ver4.repository;

import com.deerufin.keelungsightsviewer_ver4.entity.Sight;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SightRepository extends MongoRepository<Sight, String> {
//    List<Sight> findByZone(String Zone);
    @Query("{ 'zone': ?0 }")
    List<Sight> findByZone(String zone);
}