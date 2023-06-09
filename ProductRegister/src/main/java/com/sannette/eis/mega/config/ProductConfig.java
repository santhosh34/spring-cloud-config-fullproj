package com.sannette.eis.mega.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@RefreshScope
public class ProductConfig {
    @Value("${brand}")
    private String brand;
    @Value("${category}")
    private String category;
    @Value("${model}")
    private String model;
    @Value("${cost}")
    private String cost;
}
