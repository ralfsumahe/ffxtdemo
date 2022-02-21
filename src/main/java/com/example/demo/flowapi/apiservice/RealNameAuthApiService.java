package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.RealNameAuthParam;
import com.example.demo.flowapi.ability.vo.RealNameAuthResult;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/21 9:49
 */
@Component
@ApiService(eid = "30009", name = "实名认证审核")
public class RealNameAuthApiService extends BaseApiService<RealNameAuthParam, RealNameAuthResult, RealNameAuthResult> {

    /**
     * 将json转成参数
     *
     * @param config
     * @param jsonObject
     * @return
     */
    @Override
    public RealNameAuthParam getParams(ApiConfig config, JSONObject jsonObject) {
        RealNameAuthParam realNameAuthParam = jsonObject.toBean(RealNameAuthParam.class);
        return realNameAuthParam;
    }


    /**
     * 结果修改
     *
     * @param realNameAuthResult
     * @return
     */
    @Override
    public RealNameAuthResult afterResult(RealNameAuthResult realNameAuthResult) {
        return null;
    }
}
