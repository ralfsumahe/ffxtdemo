package com.example.demo.flowapi.config;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.BaseParam;
import com.example.demo.flowapi.apidao.ApiDao;
import com.example.demo.flowapi.apidao.IApiDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

/**
 * @author linkun
 * @date 2022/2/16 15:50
 */
public class ApiDaoManager {
    @Autowired
    private ApplicationContext applicationContext;

    public IApiDao getApiDao(ApiConfig apiConfig, BaseParam baseParam) {
        Optional<IApiDao> first = applicationContext.getBeansOfType(IApiDao.class).values().stream().filter(iApiDao -> {
            ApiDao annotation = iApiDao.getClass().getAnnotation(ApiDao.class);
            return annotation.eid().equals(apiConfig.getEid()) && annotation.oType().equals(baseParam.getBaseInfo().getOtype()) && annotation.syncType().equals(apiConfig.getSyncType());
        }).findFirst();
        if (!first.isPresent()) {
            first = applicationContext.getBeansOfType(IApiDao.class).values().stream().filter(iApiDao -> {
                ApiDao annotation = iApiDao.getClass().getAnnotation(ApiDao.class);
                return annotation.eid().equals(apiConfig.getEid()) && annotation.oType().equals(baseParam.getBaseInfo().getOtype()) && annotation.syncType().equals("default");
            }).findFirst();
        }
        if (!first.isPresent()) {
            first = applicationContext.getBeansOfType(IApiDao.class).values().stream().filter(iApiDao -> {
                ApiDao annotation = iApiDao.getClass().getAnnotation(ApiDao.class);
                return annotation.eid().equals(apiConfig.getEid()) && annotation.oType().equals("default") && annotation.syncType().equals("default");
            }).findFirst();
        }
        return first.get();
    }
}
