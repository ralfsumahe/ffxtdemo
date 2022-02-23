package com.example.demo.flowapi.abilitydao;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.LocationParam;
import com.example.demo.flowapi.ability.vo.LocationResult;
import com.example.demo.flowapi.config.BaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/18 15:11
 */
@Component
@AbilityDao(eid = "10002", name = "卡位置定位")
@Slf4j
public class LocationAbilityDao extends BaseAbilityDao<LocationParam, LocationResult, LocationResult> {
    /**
     * 将json转成参数
     *
     * @param config
     * @param jsonObject
     * @return
     */
    @Override
    public LocationParam getParams(ApiConfig config, JSONObject jsonObject) {
        LocationParam locationParam = JSONUtil.toBean(jsonObject, LocationParam.class);
        locationParam.setBaseInfo(new BaseInfo().setOtype("移动"));
        log.info("获取剩余定位次数");
        locationParam.setLeaveTimes(1);
        if (locationParam.getLeaveTimes() <= 0) {
            throw new RuntimeException("定位次数已经用尽！");
        }
        return locationParam;
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
