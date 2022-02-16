package com.example.demo.flowapi.apidao;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.vo.CardStatusParam;
import com.example.demo.flowapi.ability.vo.CardStatusResult;
import com.example.demo.flowapi.api.MobileApi;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 16:07
 */
@ApiDao(ebid = "ebid2", syncType = "移动")
@Component
public class CardStatusMobileApiDao implements IApiDao<CardStatusParam, CardStatusResult> {
    @Override
    public CardStatusResult process(ApiConfig apiConfig, CardStatusParam cardStatusParam) {
        System.out.println("移动apidao执行开始");
        System.out.println(String.format("参数：%s", JSONUtil.toJsonStr(cardStatusParam)));
        JSONObject post = MobileApi.get(apiConfig, JSONUtil.parseObj(cardStatusParam));
        CardStatusResult cardStatusResult = new CardStatusResult().setStatus((String) post.getByPath("data/sss"));
        System.out.println("移动apidao执行结束:" + JSONUtil.toJsonStr(cardStatusResult));
        return cardStatusResult;
    }
}
