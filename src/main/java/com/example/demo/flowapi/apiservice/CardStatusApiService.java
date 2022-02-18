package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CardStatusParam;
import com.example.demo.flowapi.ability.vo.CardStatusResult2;
import com.example.demo.flowapi.apiservice.vo.CardStatusResult;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 15:09
 */
@ApiService(eid = "eid", name = "卡状态查询服务")
@Component
public class CardStatusApiService extends BaseApiService<CardStatusParam, CardStatusResult, CardStatusResult2> {

    /**
     * 将json转成参数
     *
     * @param jsonObject
     * @return
     */
    @Override
    public CardStatusParam getParams(ApiConfig config, JSONObject jsonObject) {
        return new CardStatusParam().setCNo(jsonObject.getStr("cNo"));
    }

    /**
     * 结果修改
     *
     * @param cardStatusResult
     * @return
     */
    @Override
    public CardStatusResult2 afterResult(CardStatusResult cardStatusResult) {
        if (cardStatusResult.getStatus() == 1) {
            return new CardStatusResult2().setStatus("成功");
        } else {
            return new CardStatusResult2().setStatus("失败");
        }
    }
}
