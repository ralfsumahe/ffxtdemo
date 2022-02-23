package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CardListParam;
import com.example.demo.flowapi.ability.vo.CardListResult;
import com.example.demo.flowapi.config.BaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 16:56
 */
@ApiService(eid = "cardList", name = "卡列表查询")
@Component
@Slf4j
public class CardListApiService extends BasePubApiService<CardListParam, CardListResult, CardListResult> {

    /**
     * 将json转成参数
     *
     * @param jsonObject
     * @return
     */
    @Override
    public CardListParam getParams(ApiConfig config, JSONObject jsonObject) {
        CardListParam cardListParam = JSONUtil.toBean(jsonObject, CardListParam.class);
        cardListParam.setBaseInfo(new BaseInfo().setOtype("平台"));
        return cardListParam;
    }

    /**
     * 结果修改
     *
     * @param cardListResult
     * @return
     */
    @Override
    public CardListResult afterResult(CardListResult cardListResult) {
        log.info("结果修改");
        return cardListResult;
    }


}
