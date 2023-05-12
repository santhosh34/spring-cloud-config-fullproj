package com.sannette.eis.mega.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties("app.mail")
@NoArgsConstructor
@RefreshScope
@Data
public class NotificationConfig {

    private String host;
    private String port;
    private String userName;
    private String key1;

}
