package com.devdad.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplateConfig
 */
@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate restTemplate(){
    return new RestTemplate();
  }
}
