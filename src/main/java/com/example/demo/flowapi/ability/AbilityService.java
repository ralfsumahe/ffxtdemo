package com.example.demo.flowapi.ability;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.abilitydao.IAbilityDao;
import com.example.demo.flowapi.config.AbilityDaoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linkun
 * @date 2022/2/16 15:13
 */
@Service
@Slf4j
public class AbilityService {
    @Autowired
    private AbilityDaoManager abilityDaoManager;

    public Object process(String comId, String bNo, String eid, JSONObject params) {
        //获取配置
        log.info("=");
        log.info("能力调用开始");
        IAbilityDao abilityDao = abilityDaoManager.getApiService(eid);
        ApiConfig apiConfig = abilityDao.getApiConfig(comId, bNo, eid);
        Object result = abilityDao.process(apiConfig, abilityDao.getParams(apiConfig, params));
        Object result2 = abilityDao.afterResult(result);
        log.info("能力调用结束：" + JSONUtil.toJsonStr(result2));
        log.info("=");
        return result2;
    }
}
