package com.example.demo.flowapi.apidao;

import com.example.demo.flowapi.ApiConfig;

/**
 * @author linkun
 * @date 2022/2/16 15:46
 */
public interface IApiDao<P, R> {
    public R process(ApiConfig apiConfig, P p);
}
