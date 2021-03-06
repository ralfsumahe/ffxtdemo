package com.example.demo.flowapi.apiservice.realnameauth;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.GprsContrlParam;
import com.example.demo.flowapi.ability.dto.RealNameAuthParam;
import com.example.demo.flowapi.ability.vo.GprsContrlResult;
import com.example.demo.flowapi.ability.vo.RealNameAuthResult;
import com.example.demo.flowapi.apiservice.ApiService;
import com.example.demo.flowapi.apiservice.IApiService;
import com.example.demo.flowapi.config.ApiServiceManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/21 10:00
 */
@Slf4j
@ApiService(eid = "30009", oType = "移动", syncType = "default")
@Component
public class RealNameAuthMobileApiService implements IApiService<RealNameAuthParam, RealNameAuthResult> {
    @Autowired
    private ApiServiceManager apiServiceManager;

    @Override
    public RealNameAuthResult process(ApiConfig apiConfig, RealNameAuthParam realNameAuthParam) {
        log.info("修改实名审核认证状态！！！");
        log.info("调用移动gps接口");
        apiConfig.setEid("20002");
        apiConfig.setSyncType("中移物联V5API");
        IApiService apiDao = apiServiceManager.getApiDao(apiConfig, realNameAuthParam);
        GprsContrlResult gprsContrlResult = (GprsContrlResult) apiDao.process(apiConfig, new GprsContrlParam());
        return new RealNameAuthResult();
    }
}
