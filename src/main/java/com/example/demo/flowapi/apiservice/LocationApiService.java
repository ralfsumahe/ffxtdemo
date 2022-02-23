package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CNoParam;
import com.example.demo.flowapi.ability.vo.LocationResult;
import com.example.demo.flowapi.config.BaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/18 15:11
 */
@Component
@ApiService(eid = "10002", name = "卡位置定位")
@Slf4j
public class LocationApiService extends BaseApiService<CNoParam, LocationResult, LocationResult> {
    /**
     * 将json转成参数
     *
     * @param config
     * @param jsonObject
     * @return
     */
    @Override
    public CNoParam getParams(ApiConfig config, JSONObject jsonObject) {
        log.info("获取剩余定位次数");
        CNoParam cNoParam = JSONUtil.toBean(jsonObject, CNoParam.class);
        cNoParam.setBaseInfo(new BaseInfo().setOtype("移动"));
        return cNoParam;
    }

    /**
     * 结果修改
     *
     * @param locationResult
     * @return
     */
    @Override
    public LocationResult afterResult(LocationResult locationResult) {
        log.info("定位已用次数+1");
        return locationResult;
    }
}
