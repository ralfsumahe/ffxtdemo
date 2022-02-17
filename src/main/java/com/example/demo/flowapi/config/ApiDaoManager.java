package com.example.demo.flowapi.config;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.apidao.ApiDao;
import com.example.demo.flowapi.apidao.IApiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author linkun
 * @date 2022/2/16 15:50
 */
public class ApiDaoManager {
    @Autowired
    private ApplicationContext applicationContext;

    public IApiDao getApiDao(ApiConfig apiConfig) {
        return applicationContext.getBeansOfType(IApiDao.class).values().stream().filter(iApiDao -> {
            ApiDao annotation = iApiDao.getClass().getAnnotation(ApiDao.class);
            if (annotation.ebid().equals(apiConfig.getEbid()) && annotation.eid().equals(apiConfig.getEid())) {
                return true;
            }
            return false;
        }).findFirst().get();

    }
}
