package com.sannette.eis.mega.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NotificationController {

    @Value("${model}")
    private String model;

    @Value("${cost}")
    private String cost;

    @GetMapping("/products/{id}")
    public String getSth(){
        return "{"+this.model+":"+this.cost+"}";
    }
}
