package com.sannette.eis.mega.controllers;

import com.sannette.eis.mega.config.ProductConfig;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/product-register")
public class ProductsController {

        @Autowired
        private ProductConfig productConfig;

        @GetMapping("/properties/{propertyName}")
        public Mono<String> getAProperty(@PathVariable String propertyName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException{
                return Mono.just((String)PropertyUtils.getProperty(productConfig, propertyName));
        }
}
