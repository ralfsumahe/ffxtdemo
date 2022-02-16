package com.example.demo.flowapi.apiservice;

import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.apidao.IApiDao;
import com.example.demo.flowapi.config.ApiDaoManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author linkun
 * @date 2022/2/16 18:26
 */
public abstract class BaseApiService<P, R> implements IApiService<P, R> {
    @Autowired
    private ApiDaoManager apiDaoManager;

    /**
     * 执行调用
     *
     * @param config
     * @param p
     * @return
     */
    @Override
    public R getResult(ApiConfig config, P p) {
        String name = this.getClass().getAnnotation(ApiService.class).name();
        System.out.println(name + "调用开始");
        IApiDao apidao = apiDaoManager.getApiDao(config);
        R result = (R) apidao.process(config, p);
        System.out.println(name + "调用结束" + JSONUtil.toJsonStr(result));
        return result;
    }
}
