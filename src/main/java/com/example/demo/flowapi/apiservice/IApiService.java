package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONObject;
import com.example.demo.flowapi.ApiConfig;

/**
 * @author linkun
 * @date 2022/2/16 15:05
 */
public interface IApiService<P, R, R2> {
    /**
     * 将json转成参数
     *
     * @param jsonObject
     * @return
     */
    P getParams(JSONObject jsonObject);

    /**
     * 执行调用
     *
     * @param config
     * @param p
     * @return
     */
    public R process(ApiConfig config, P p);

    /**
     * 结果修改
     *
     * @param r
     * @return
     */
    R2 getResult(R r);

}
