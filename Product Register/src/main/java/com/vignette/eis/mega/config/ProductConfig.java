package com.vignette.eis.mega.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class ProductConfig {
    @Value("${model}")
    private String model;
    @Value("${cost}")
    private String cost;
}
