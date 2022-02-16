package com.example.demo.flowapi.api;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;

/**
 * @author linkun
 * @date 2022/2/16 16:06
 */
public class MobileApi {
    public static JSONObject get(ApiConfig apiConfig, JSONObject param) {
        System.out.println("调用移动api接口获取开始");
        String result = "{\n" +
                "    \"code\": 10000,\n" +
                "    \"msg\": \"成功\",\n" +
                "    \"data\": {\n" +
                "        \"cNo\":\"cNo\",\n" +
                "        \"sss\":1\n" +
                "    }\n" +
                "}";
        System.out.println("调用移动api接口获取结束：" + result);
        return JSONUtil.parseObj(result);
    }
}