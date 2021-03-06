package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CardListParam;
import com.example.demo.flowapi.ability.vo.CardListResult;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 17:19
 */
@ApiService(eid = "cardList", syncType = "平台", oType = "平台")
@Component
public class CardListAllApiService implements IApiService<CardListParam, CardListResult> {

    @Override
    public CardListResult process(ApiConfig apiConfig, CardListParam cardListParam) {
        String result = "{\n" +
                "    \"code\": 10001,\n" +
                "    \"data\": [\"1\",\"2\",\"3\",\"4\"],\n" +
                "    \"msg\": \"IP地址鉴权不通过\"\n" +
                "}";
        JSONArray data = (JSONArray) JSONUtil.getByPath(JSONUtil.parseObj(result), "data");
        return new CardListResult().setCardNos(data.toList(String.class));
    }
}
