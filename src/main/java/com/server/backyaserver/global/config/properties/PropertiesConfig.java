package com.server.backyaserver.global.config.properties;

import com.server.backyaserver.global.properties.jwt.JwtProperties;
import com.server.backyaserver.global.properties.oauth.OauthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({
        JwtProperties.class,
        OauthProperties.class
})
@Configuration
public class PropertiesConfig {

}
