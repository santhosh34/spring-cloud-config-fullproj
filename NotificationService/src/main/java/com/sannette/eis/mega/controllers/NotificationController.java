package com.sannette.eis.mega.controllers;

import com.sannette.eis.mega.config.NotificationConfig;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping("/notification-service")
public class NotificationController {

    @Autowired
    private NotificationConfig  notificationConfig;

    @GetMapping("/properties/{propertyName}")
    public Mono<String> getAProperty(@PathVariable String propertyName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException{
        return Mono.just((String) PropertyUtils.getProperty(notificationConfig, propertyName));
    }
}
