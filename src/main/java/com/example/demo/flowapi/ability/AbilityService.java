package com.example.demo.flowapi.ability;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
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
        ApiConfig apiConfig = getApiConfig(comId, bNo, eid);
        IApiService apiService = apiServiceManager.getApiService(eid);
        Object result = apiService.getResult(apiConfig, apiService.getParams(params));
        log.info("能力调用结束：" + JSONUtil.toJsonStr(result));
        return result;
    }

    private ApiConfig getApiConfig(String comId, String bNo, String eid) {
        ApiConfig apiConfig = new ApiConfig().setApiid("apiid")
                .setApikey("apikey")
                .setApiurl("apiurl")
                .setEbid(eid)
                .setEcode("ecode")
                .setEurl("eurl");

        String[] ebids = new String[]{"ebid1", "ebid2"};
        if (eid.equals("eid")) {
            apiConfig.setEbid(ebids[Math.abs(RandomUtil.getRandom().nextInt()) % 2]);
        } else {
            apiConfig.setEbid("cardListEbid");
        }

        return apiConfig;
    }
}
