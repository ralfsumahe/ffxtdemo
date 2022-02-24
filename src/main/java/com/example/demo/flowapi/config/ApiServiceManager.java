package com.example.demo.flowapi.config;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.BaseParam;
import com.example.demo.flowapi.apiservice.ApiService;
import com.example.demo.flowapi.apiservice.IApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

/**
 * @author linkun
 * @date 2022/2/16 15:50
 */
public class ApiServiceManager {
    @Autowired
    private ApplicationContext applicationContext;

    public IApiService getApiDao(ApiConfig apiConfig, BaseParam baseParam) {
        Optional<IApiService> first = applicationContext.getBeansOfType(IApiService.class).values().stream().filter(iApiDao -> {
            ApiService annotation = iApiDao.getClass().getAnnotation(ApiService.class);
            return annotation.eid().equals(apiConfig.getEid()) && annotation.oType().equals(baseParam.getBaseInfo().getOtype()) && annotation.syncType().equals(apiConfig.getSyncType());
        }).findFirst();
        if (!first.isPresent()) {
            first = applicationContext.getBeansOfType(IApiService.class).values().stream().filter(iApiDao -> {
                ApiService annotation = iApiDao.getClass().getAnnotation(ApiService.class);
                return annotation.eid().equals(apiConfig.getEid()) && annotation.oType().equals(baseParam.getBaseInfo().getOtype()) && annotation.syncType().equals("default");
            }).findFirst();
        }
        if (!first.isPresent()) {
            first = applicationContext.getBeansOfType(IApiService.class).values().stream().filter(iApiDao -> {
                ApiService annotation = iApiDao.getClass().getAnnotation(ApiService.class);
                return annotation.eid().equals(apiConfig.getEid()) && annotation.oType().equals("default") && annotation.syncType().equals("default");
            }).findFirst();
        }
        return first.get();
    }
}
