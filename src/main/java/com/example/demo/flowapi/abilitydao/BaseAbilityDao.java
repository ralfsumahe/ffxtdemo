package com.example.demo.flowapi.abilitydao;

import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.BaseParam;
import com.example.demo.flowapi.apiservice.IApiService;
import com.example.demo.flowapi.config.ApiServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author linkun
 * @date 2022/2/16 18:26
 */
@Slf4j
public abstract class BaseAbilityDao<P extends BaseParam, R, R2> implements IAbilityDao<P, R, R2> {
    @Autowired
    private ApiServiceManager apiServiceManager;


    /**
     * 获取api配置项
     *
     * @param comId
     * @param bNo
     * @param eid
     * @return
     */
    @Override
    public ApiConfig getApiConfig(String comId, String bNo, String eid) {
        ApiConfig apiConfig = new ApiConfig()
                .setEid(eid);
        if (comId.indexOf("小米") != -1) {
            apiConfig.setSyncType("小米");
        } else if (comId.indexOf("移动") != -1) {
            apiConfig.setSyncType("移动");
        } else {
            apiConfig.setSyncType("默认");
        }

        return apiConfig;
    }

    /**
     * 执行调用
     *
     * @param config
     * @param p
     * @return
     */
    @Override
    public R process(ApiConfig config, P p) {
        String name = this.getClass().getAnnotation(AbilityDao.class).name();
        log.info("==");
        log.info(name + "api调用开始");
        IApiService apidao = apiServiceManager.getApiDao(config, p);
        R result = (R) apidao.process(config, p);
        log.info(name + "api调用结束" + JSONUtil.toJsonStr(result));
        log.info("==");
        return result;
    }
}
