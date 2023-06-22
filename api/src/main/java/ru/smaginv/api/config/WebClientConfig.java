package ru.smaginv.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class WebClientConfig {

    private final String scheme;
    private final String host;
    private final String port;
    private final String url;

    @Autowired
    public WebClientConfig(PropertiesConfig propertiesConfig) {
        this.scheme = propertiesConfig.dataURL().getScheme();
        this.host = propertiesConfig.dataURL().getHost();
        this.port = propertiesConfig.dataURL().getPort();
        this.url = propertiesConfig.dataURL().getUrl();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(getBaseUrl())
                .build();
    }

    private String getBaseUrl() {
        return UriComponentsBuilder.newInstance()
                .scheme(scheme)
                .host(host)
                .port(port)
                .path(url)
                .build()
                .toUriString();
    }
}
