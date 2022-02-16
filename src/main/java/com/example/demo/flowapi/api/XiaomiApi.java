package com.example.demo.flowapi.api;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;

/**
 * @author linkun
 * @date 2022/2/16 15:33
 */
public class XiaomiApi {
    public static JSONObject post(ApiConfig apiConfig, JSONObject param) {
        System.out.println("调用小米通用api接口获取开始");
        String result = "{\n" +
                "    \"code\": 10000,\n" +
                "    \"msg\": \"成功\",\n" +
                "    \"data\": {\n" +
                "        \"cNo\":\"cNo\",\n" +
                "        \"status\":1\n" +
                "    }\n" +
                "}";
        System.out.println("调用小米通用api接口获取结束：" + result);
        return JSONUtil.parseObj(result);
    }
}
