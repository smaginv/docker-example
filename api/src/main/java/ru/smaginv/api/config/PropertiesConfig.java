package ru.smaginv.api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {

    @Bean
    @ConfigurationProperties(prefix = "api.data")
    public DataURL dataURL() {
        return new DataURL();
    }

    @Getter
    @Setter
    public static class DataURL {
        private String scheme;
        private String host;
        private String port;
        private String url;
    }
}
