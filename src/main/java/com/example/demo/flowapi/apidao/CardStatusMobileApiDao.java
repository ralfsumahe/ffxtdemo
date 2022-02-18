package com.example.demo.flowapi.apidao;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.vo.CardStatusParam;
import com.example.demo.flowapi.ability.vo.CardStatusResult;
import com.example.demo.flowapi.api.MobileApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 16:07
 */
@ApiDao(eid = "eid", syncType = "移动")
@Component
@Slf4j
public class CardStatusMobileApiDao implements IApiDao<CardStatusParam, CardStatusResult> {
    @Override
    public CardStatusResult process(ApiConfig apiConfig, CardStatusParam cardStatusParam) {
        log.info("移动apidao执行开始");
        log.info(String.format("参数：%s", JSONUtil.toJsonStr(cardStatusParam)));
        JSONObject post = MobileApi.get(apiConfig, JSONUtil.parseObj(cardStatusParam));
        CardStatusResult cardStatusResult = new CardStatusResult().setStatus((int) post.getByPath("data.sss"));
        log.info("移动apidao执行结束:" + JSONUtil.toJsonStr(cardStatusResult));
        return cardStatusResult;
    }
}
