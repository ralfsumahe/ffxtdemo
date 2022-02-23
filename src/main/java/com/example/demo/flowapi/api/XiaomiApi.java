package com.example.demo.flowapi.api;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import lombok.extern.slf4j.Slf4j;

/**
 * @author linkun
 * @date 2022/2/16 15:33
 */
@Slf4j
public class XiaomiApi {
    public static JSONObject post(ApiConfig apiConfig, JSONObject param) {
        log.info("====");
        log.info("调用小米通用api接口获取开始");
        String result = "{\n" +
                "    \"code\": 10000,\n" +
                "    \"msg\": \"成功\",\n" +
                "    \"data\": {\n" +
                "        \"cNo\":\"cNo\",\n" +
                "        \"status\":1\n" +
                "    }\n" +
                "}";
        log.info("调用小米通用api接口获取结束：" + result.replaceAll("\\n", ""));
        log.info("====");
        return JSONUtil.parseObj(result);
    }
}
