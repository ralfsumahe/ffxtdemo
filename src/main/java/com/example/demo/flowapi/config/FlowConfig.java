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
    public ApiServiceManager apiServiceManager() {
        return new ApiServiceManager();
    }

    @Bean
    public ApiDaoManager apiDaoManager() {
        return new ApiDaoManager();
    }

}
