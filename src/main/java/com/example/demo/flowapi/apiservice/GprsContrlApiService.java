package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.GprsContrlParam;
import com.example.demo.flowapi.ability.vo.GprsContrlResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/21 10:27
 */
@Slf4j
@Component
@ApiService(eid = "20021", name = "Gprs开停")
public class GprsContrlApiService extends BaseApiService<GprsContrlParam, GprsContrlResult, GprsContrlResult> {
    /**
     * 将json转成参数
     *
     * @param config
     * @param jsonObject
     * @return
     */
    @Override
    public GprsContrlParam getParams(ApiConfig config, JSONObject jsonObject) {
        return JSONUtil.toBean(jsonObject, GprsContrlParam.class);
    }

    /**
     * 结果修改
     *
     * @param gprsContrlResult
     * @return
     */
    @Override
    public GprsContrlResult afterResult(GprsContrlResult gprsContrlResult) {
        return null;
    }
}
