package com.vignette.eis.mega.controllers;

import com.vignette.eis.mega.config.ProductConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product-register")
public class GamesOrgController {

//        @Value("${model}")
//        private String model;
//
//        @Value("${cost}")
//        private String cost;

        @Autowired
        private ProductConfig productConfig;

        @GetMapping("/{propertyName}")
        public Mono<String> getConfigurationProp(@PathVariable String propertyName){
                  return Mono.just("{"+productConfig.getModel()+":"+ productConfig.getCost()+"}");
        }


}
