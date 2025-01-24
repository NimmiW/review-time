package com.movietime.movie_service.webclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


@Configuration
public class RatingWebClientConfig {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl("http://api-gateway")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public RatingWebClient ratingWebClient(){
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory.builderFor(WebClientAdapter.create(getWebClient()))
                .build();

        return httpServiceProxyFactory.createClient(RatingWebClient.class);
    }
}
