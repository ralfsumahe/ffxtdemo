package com.example.demo.flowapi.apidao.gprscontrl;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.GprsContrlParam;
import com.example.demo.flowapi.ability.vo.GprsContrlResult;
import com.example.demo.flowapi.apidao.ApiDao;
import com.example.demo.flowapi.apidao.IApiDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/21 10:32
 */
@Slf4j
@Component
@ApiDao(eid = "20002", oType = "移动", syncType = "中移物联V5API")
public class MobileGrpsContrlApiDao implements IApiDao<GprsContrlParam, GprsContrlResult> {
    @Override
    public GprsContrlResult process(ApiConfig apiConfig, GprsContrlParam gprsContrlParam) {
        log.info("调用移动-中移物联V5API gprs开停接口");
        return new GprsContrlResult();
    }
}
