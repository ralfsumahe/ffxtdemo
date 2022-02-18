package com.example.demo.flowapi.config;

import com.example.demo.flowapi.ApiConfig;
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

    public IApiDao getApiDao(ApiConfig apiConfig) {
        Optional<IApiDao> first = applicationContext.getBeansOfType(IApiDao.class).values().stream().filter(iApiDao -> {
            ApiDao annotation = iApiDao.getClass().getAnnotation(ApiDao.class);
            if (annotation.syncType().equals(apiConfig.getSyncType()) && annotation.eid().equals(apiConfig.getEid())) {
                return true;
            }
            return false;
        }).findFirst();
        if (!first.isPresent()) {
            throw new RuntimeException(apiConfig.getEid() + "能力" + apiConfig.getSyncType() + "接口未实现");
        }
        return first.get();
    }
}
