package com.agrichallenge.agdata.controller;

import com.agrichallenge.agdata.model.AgData;
import com.agrichallenge.agdata.service.AgDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/agdata")
public class AgDataController {

    @Autowired
    private AgDataService agDataService;

    @GetMapping("")
    public ResponseEntity<List<AgData>> getAllProducts() throws IOException {
        List<AgData> products = agDataService.loadAgData();
        if (products.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/crop-count")
    public ResponseEntity<?> getCropCount(@RequestParam("cropName") String cropName) throws IOException{
        Long agData = agDataService.getCropCount(cropName);
        if(agData == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(agData,HttpStatus.OK);
    }

    @GetMapping("/average-yield")
    public ResponseEntity<?> getAverage(@RequestParam("cropName") String cropName) throws IOException{
        double agData = agDataService.getAverageYield(cropName);
        return new ResponseEntity<>(agData,HttpStatus.OK);
    }


    @GetMapping("/by-region")
    public ResponseEntity<?> getSpecificRegionData(@RequestParam("region") String region) throws IOException{
        List<AgData> agDatas = agDataService.getRecordsByRegion(region);
        if(agDatas.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(agDatas,HttpStatus.OK);
    }


}
