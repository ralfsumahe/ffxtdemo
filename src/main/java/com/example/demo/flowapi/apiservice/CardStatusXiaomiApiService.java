package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CardStatusParam;
import com.example.demo.flowapi.abilitydao.vo.CardStatusResult;
import com.example.demo.flowapi.apidao.xiaomi.CardStatusXiaomiApiDao;
import com.example.demo.flowapi.apidao.xiaomi.dto.XiaomiCardStatusDto;
import com.example.demo.flowapi.apidao.xiaomi.vo.XiaomiCardStatusVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/16 15:43
 */
@ApiService(eid = "eid", syncType = "小米", oType = "移动")
@Component
@Slf4j
public class CardStatusXiaomiApiService implements IApiService<CardStatusParam, CardStatusResult> {
    @Autowired
    private CardStatusXiaomiApiDao dao;

    @Override
    public CardStatusResult process(ApiConfig apiConfig, CardStatusParam cardStatusParam) {
        log.info("小米apiservice执行开始");
        log.info(String.format("参数：%s", JSONUtil.toJsonStr(cardStatusParam)));
        XiaomiCardStatusVo xiaomiCardStatusVo = dao.cardStatus(apiConfig, new XiaomiCardStatusDto().setCNo(cardStatusParam.getCNo()));
        CardStatusResult cardStatusResult = new CardStatusResult().setStatus(xiaomiCardStatusVo.getStatus());
        log.info("小米apiservice执行结束:" + JSONUtil.toJsonStr(cardStatusResult));
        return cardStatusResult;
    }
}
