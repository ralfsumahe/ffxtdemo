package com.example.demo.flowapi.ability;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.apiservice.IApiService;
import com.example.demo.flowapi.config.ApiServiceManager;
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
    private ApiServiceManager apiServiceManager;

    public Object process(String comId, String bNo, String eid, JSONObject params) {
        //获取配置
        log.info("能力调用开始");
        IApiService apiService = apiServiceManager.getApiService(eid);
        Object result = apiService.process(apiService.getApiConfig(comId, bNo, eid), apiService.getParams(params));
        Object result2 = apiService.getResult(result);
        log.info("能力调用结束：" + JSONUtil.toJsonStr(result2));
        return result2;
    }
}
