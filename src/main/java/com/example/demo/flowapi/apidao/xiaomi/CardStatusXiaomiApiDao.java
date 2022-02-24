package com.example.demo.flowapi.apidao.xiaomi;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.api.XiaomiApi;
import com.example.demo.flowapi.apidao.xiaomi.dto.XiaomiCardStatusDto;
import com.example.demo.flowapi.apidao.xiaomi.vo.XiaomiCardStatusVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/23 16:53
 */
@Component
@Slf4j
public class CardStatusXiaomiApiDao {

    public XiaomiCardStatusVo cardStatus(ApiConfig apiConfig, XiaomiCardStatusDto dto) {
        log.info("===");
        log.info("xiaomiApiDao开始执行");
        JSONObject result = XiaomiApi.post(apiConfig, JSONUtil.parseObj(dto));
        XiaomiCardStatusVo xiaomiCardStatusVo = new XiaomiCardStatusVo().setStatus((int) JSONUtil.getByPath(result, "data.status"));
        log.info("xiaomiApiDao执行结束{}", xiaomiCardStatusVo);
        log.info("===");
        return xiaomiCardStatusVo;
    }
}
