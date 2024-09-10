package com.deerufin.keelungsightsviewer_ver4.entity;

import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;


@Document(collection = "SightCollection")
public class Sight implements Serializable {

    @Id
    private String id;
    private String SightName;
    @Field("zone")
    private String Zone;
    private String Category;
    private String PhotoURL;
    private String Description;
    private String Address;

    public Sight(){

    }

    public Sight(Object o, String defaultSightName, String defaultZone, String defaultCategory, String defaultPhotoUrl, String defaultDescription, String defaultAddress) {
        SightName = defaultSightName;
        Zone = defaultZone;
        Category = defaultCategory;
        PhotoURL = defaultPhotoUrl;
        Description = defaultDescription;
        Address = defaultAddress;
    }


    @Override
    public String toString() {
        return "SightName: " +this.getSightName()+"\n"+
                "Zone: " +this.getZone()+"\n"+
                "Category: " +this.getCategory()+"\n"+
                "PhotoURL: " +this.getPhotoURL()+"\n"+
                "Description: " +this.getDescription()+"\n"+
                "Address: " +this.getAddress()+"\n\n";
    }

    public String getSightName() {
        return SightName;
    }

    public void setSightName(String sightName) {
        SightName = sightName;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String zone) {
        Zone = zone;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhotoURL() {
        return PhotoURL;
    }

    public void setPhotoURL(String photoURL) {
        PhotoURL = photoURL;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
