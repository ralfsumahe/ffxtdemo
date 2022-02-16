package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import com.example.demo.flowapi.ability.vo.CardStatusParam;
import com.example.demo.flowapi.ability.vo.CardStatusResult;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 15:09
 */
@ApiService(eid = "eid", name = "卡状态查询服务")
@Component
public class CardStatusApiService extends BaseApiService<CardStatusParam, CardStatusResult> {

    /**
     * 将json转成参数
     *
     * @param jsonObject
     * @return
     */
    @Override
    public CardStatusParam getParams(JSONObject jsonObject) {
        return new CardStatusParam().setCNo(jsonObject.getStr("cNo"));
    }
}
