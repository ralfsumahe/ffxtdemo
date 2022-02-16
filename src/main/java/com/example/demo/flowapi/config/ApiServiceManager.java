package com.example.demo.flowapi.config;

import com.example.demo.flowapi.apiservice.ApiService;
import com.example.demo.flowapi.apiservice.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author linkun
 * @date 2022/2/16 15:23
 */
public class ApiServiceManager {
    @Autowired
    private ApplicationContext applicationContext;

    public IApiService getApiService(String eid) {
        //通过注解获取
        return applicationContext.getBeansOfType(IApiService.class).values().stream().filter(iApiService -> {
            ApiService annotation = iApiService.getClass().getAnnotation(ApiService.class);
            if (annotation.eid().equals(eid)) {
                return true;
            }
            return false;
        }).findFirst().get();
    }
}
