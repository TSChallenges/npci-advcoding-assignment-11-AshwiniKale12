package com.agrichallenge.agdata.model;

public class AgData {

    private Integer id;
    private String crop;
    private String region;
    private Integer yield;
    private Integer year;

    public AgData(){}

    public  AgData(Integer id, String crop,String region,Integer yield,Integer year){
        this.id = id;
        this.crop = crop;
        this.region = region;
        this.yield = yield;
        this.year = year;
    }


    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    public void setCrop(String crop){
        this.crop = crop;
    }

    public String getCrop(){
        return crop;
    }

    public void setRegion(String region){
        this.region = region;
    }

    public String getRegion(){
        return region;
    }

    public void setYield(Integer yield){
        this.yield = yield;
    }

    public Integer getYield(){
        return yield;
    }

    public void setYear(Integer year){
        this.year = year;
    }

    public Integer getYear(){
        return year;
    }
}
