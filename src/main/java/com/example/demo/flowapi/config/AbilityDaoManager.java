package com.example.demo.flowapi.config;

import com.example.demo.flowapi.abilitydao.AbilityDao;
import com.example.demo.flowapi.abilitydao.IAbilityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

/**
 * @author linkun
 * @date 2022/2/16 15:23
 */
public class AbilityDaoManager {
    @Autowired
    private ApplicationContext applicationContext;

    public IAbilityDao getApiService(String eid) {
        //通过注解获取
        Optional<IAbilityDao> first = applicationContext.getBeansOfType(IAbilityDao.class).values().stream().filter(iAbilityDao -> {
            AbilityDao annotation = iAbilityDao.getClass().getAnnotation(AbilityDao.class);
            if (annotation.eid().equals(eid)) {
                return true;
            }
            return false;
        }).findFirst();
        if (!first.isPresent()) {
            throw new RuntimeException(eid + "能力未实现");
        }
        return first.get();
    }

}
