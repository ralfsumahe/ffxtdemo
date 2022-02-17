package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ability.vo.CardListParam;
import com.example.demo.flowapi.ability.vo.CardListResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 16:56
 */
@ApiService(eid = "cardList", name = "卡列表查询")
@Component
@Slf4j
public class CardListApiService extends BaseApiService<CardListParam, CardListResult, CardListResult> {

    /**
     * 将json转成参数
     *
     * @param jsonObject
     * @return
     */
    @Override
    public CardListParam getParams(JSONObject jsonObject) {
        CardListParam cardListParam = JSONUtil.toBean(jsonObject, CardListParam.class);
        return cardListParam;
    }

    /**
     * 结果修改
     *
     * @param cardListResult
     * @return
     */
    @Override
    public CardListResult getResult(CardListResult cardListResult) {
        log.info("结果修改");
        return cardListResult;
    }


}
