package com.sannette.eis.mega.controllers;

import com.sannette.eis.mega.config.ProductConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product-register")
public class ProductsController {

        @Autowired
        private ProductConfig productConfig;

        @GetMapping("/properties")
        public Mono<String> getConfigurationProp(@PathVariable String propertyName){
                  return Mono.just(productConfig);
        }

        @GetMapping("/properties/{propertyName}")
        public Mono<String> getConfigurationProp(@PathVariable String propertyName){
                return Mono.just(productConfig);
        }


}
