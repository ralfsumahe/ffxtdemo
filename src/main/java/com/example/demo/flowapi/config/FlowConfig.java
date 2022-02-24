package com.example.demo.flowapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author linkun
 * @date 2022/2/16 16:45
 */
@Configuration
public class FlowConfig {
    @Bean
    public AbilityDaoManager apiServiceManager() {
        return new AbilityDaoManager();
    }

    @Bean
    public ApiServiceManager apiDaoManager() {
        return new ApiServiceManager();
    }

}
