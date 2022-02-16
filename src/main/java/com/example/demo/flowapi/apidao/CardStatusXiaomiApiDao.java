package com.example.demo.flowapi.apidao;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.vo.CardStatusParam;
import com.example.demo.flowapi.ability.vo.CardStatusResult;
import com.example.demo.flowapi.api.XiaomiApi;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 15:43
 */
@ApiDao(ebid = "ebid1", syncType = "小米")
@Component
public class CardStatusXiaomiApiDao implements IApiDao<CardStatusParam, CardStatusResult> {

    @Override
    public CardStatusResult process(ApiConfig apiConfig, CardStatusParam cardStatusParam) {
        System.out.println("小米apidao执行开始");
        System.out.println(String.format("参数：%s", JSONUtil.toJsonStr(cardStatusParam)));
        JSONObject post = XiaomiApi.post(apiConfig, JSONUtil.parseObj(cardStatusParam));
        CardStatusResult cardStatusResult = new CardStatusResult().setStatus((String) post.getByPath("data/status"));
        System.out.println("小米apidao执行结束:" + JSONUtil.toJsonStr(cardStatusResult));
        return cardStatusResult;
    }
}
