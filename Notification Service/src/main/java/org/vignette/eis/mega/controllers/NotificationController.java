package org.vignette.eis.mega.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Value("${cost}")
    private String cost;

    @GetMapping("/me")
    public String getSth(){
        return "Santhohkumar Nagulanchi"+this.cost;
    }
}
