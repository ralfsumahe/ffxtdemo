package com.example.demo.flowapi.abilitydao;

import cn.hutool.json.JSONObject;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.BaseParam;

/**
 * @author linkun
 * @date 2022/2/16 15:05
 */
public interface IAbilityDao<P extends BaseParam, R, R2> {
    /**
     * 获取api配置项
     *
     * @param comId
     * @param bNo
     * @param eid
     * @return
     */
    public ApiConfig getApiConfig(String comId, String bNo, String eid);

    /**
     * 将json转成参数
     *
     * @param jsonObject
     * @return
     */
    P getParams(ApiConfig config, JSONObject jsonObject);

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
    R2 afterResult(R r);

}
