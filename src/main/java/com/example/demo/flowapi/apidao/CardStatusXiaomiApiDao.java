package com.example.demo.flowapi.apidao;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CardStatusParam;
import com.example.demo.flowapi.api.XiaomiApi;
import com.example.demo.flowapi.apiservice.vo.CardStatusResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 15:43
 */
@ApiDao(eid = "eid", syncType = "小米", oType = "移动")
@Component
@Slf4j
public class CardStatusXiaomiApiDao implements IApiDao<CardStatusParam, CardStatusResult> {

    @Override
    public CardStatusResult process(ApiConfig apiConfig, CardStatusParam cardStatusParam) {
        log.info("小米apidao执行开始");
        log.info(String.format("参数：%s", JSONUtil.toJsonStr(cardStatusParam)));
        JSONObject post = XiaomiApi.post(apiConfig, JSONUtil.parseObj(cardStatusParam));
        CardStatusResult cardStatusResult = new CardStatusResult().setStatus((int) post.getByPath("data.status"));
        log.info("小米apidao执行结束:" + JSONUtil.toJsonStr(cardStatusResult));
        return cardStatusResult;
    }
}
