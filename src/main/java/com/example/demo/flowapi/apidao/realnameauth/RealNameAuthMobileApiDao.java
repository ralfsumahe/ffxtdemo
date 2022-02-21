package com.example.demo.flowapi.apidao.realnameauth;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.GprsContrlParam;
import com.example.demo.flowapi.ability.dto.RealNameAuthParam;
import com.example.demo.flowapi.ability.vo.GprsContrlResult;
import com.example.demo.flowapi.ability.vo.RealNameAuthResult;
import com.example.demo.flowapi.apidao.ApiDao;
import com.example.demo.flowapi.apidao.IApiDao;
import com.example.demo.flowapi.config.ApiDaoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/21 10:00
 */
@Slf4j
@ApiDao(eid = "30009", oType = "移动", syncType = "default")
@Component
public class RealNameAuthMobileApiDao implements IApiDao<RealNameAuthParam, RealNameAuthResult> {
    @Autowired
    private ApiDaoManager apiDaoManager;

    @Override
    public RealNameAuthResult process(ApiConfig apiConfig, RealNameAuthParam realNameAuthParam) {
        log.info("修改实名审核认证状态！！！");
        log.info("调用移动gps接口");
        apiConfig.setEid("20002");
        apiConfig.setSyncType("中移物联V5API");
        IApiDao apiDao = apiDaoManager.getApiDao(apiConfig);
        GprsContrlResult gprsContrlResult = (GprsContrlResult) apiDao.process(apiConfig, new GprsContrlParam());
        return new RealNameAuthResult();
    }
}
