package com.example.demo.flowapi.abilitydao;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CardStatusParam;
import com.example.demo.flowapi.ability.vo.CardStatusResult2;
import com.example.demo.flowapi.abilitydao.vo.CardStatusResult;
import com.example.demo.flowapi.config.BaseInfo;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 15:09
 */
@AbilityDao(eid = "eid", name = "卡状态查询服务")
@Component
public class CardStatusAbilityDao extends BaseAbilityDao<CardStatusParam, CardStatusResult, CardStatusResult2> {

    /**
     * 将json转成参数
     *
     * @param jsonObject
     * @return
     */
    @Override
    public CardStatusParam getParams(ApiConfig config, JSONObject jsonObject) {
        CardStatusParam cardStatusParam = JSONUtil.toBean(jsonObject, CardStatusParam.class);
        cardStatusParam.setBaseInfo(new BaseInfo().setOtype("移动"));
        return cardStatusParam;
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
