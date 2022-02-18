package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CNoParam;
import com.example.demo.flowapi.ability.vo.LocationResult;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/18 15:11
 */
@Component
@ApiService(eid = "10002", name = "卡位置定位")
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
        CNoParam cNoParam = JSONUtil.toBean(jsonObject, CNoParam.class);
        //获取是否还有定位条数
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
        return locationResult;
    }
}
