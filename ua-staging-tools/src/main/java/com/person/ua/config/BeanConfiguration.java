package com.person.ua.config;

import com.gtech.cloud.hub.client.ApiClient;
import com.gtech.cloud.hub.client.ApiClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Value("${hub.client.url:https://oms-hub-stg.underarmour.cn}")
    private String hubApiClientUrl;

    @Value("${hub.appId:fulfill}")
    private String appId;

    @Value("${hub.secret:zcXZNKIHrnkeo5u09924jihskhfhwk4hkhkfjbksefkjsbfkcf}")
    private String appSecret;

    @Bean
    public ApiClient apiClient() {
        return ApiClientBuilder.endpoint(hubApiClientUrl)
                .appId(appId)
                .appSecret(appSecret)
                .build();
    }
}
