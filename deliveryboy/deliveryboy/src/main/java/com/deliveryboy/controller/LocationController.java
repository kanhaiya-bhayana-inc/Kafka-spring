package com.deliveryboy.controller;
import java.util.Map;
import com.deliveryboy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> UpdateLocation(){
        String k1 = "key1";
        String v1 = "Location updated";
        for (int i = 0; i<= 1000000; i++){
            this.kafkaService.updateLocation("Current location is - - " + i);
        }
        return new ResponseEntity<>(Map.of(k1,v1), HttpStatus.OK);
    }

}
