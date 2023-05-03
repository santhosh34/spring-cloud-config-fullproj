package com.vignette.itt.dega.controllers;

import com.vignette.itt.dega.config.ProductConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
