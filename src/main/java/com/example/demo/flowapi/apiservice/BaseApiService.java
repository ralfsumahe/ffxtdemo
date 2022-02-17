package com.example.demo.flowapi.apiservice;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.apidao.IApiDao;
import com.example.demo.flowapi.config.ApiDaoManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author linkun
 * @date 2022/2/16 18:26
 */
@Slf4j
public abstract class BaseApiService<P, R, R2> implements IApiService<P, R, R2> {
    @Autowired
    private ApiDaoManager apiDaoManager;


    /**
     * 获取api配置项
     *
     * @param comId
     * @param bNo
     * @param eid
     * @return
     */
    @Override
    public ApiConfig getApiConfig(String comId, String bNo, String eid) {
        ApiConfig apiConfig = new ApiConfig().setApiid("apiid")
                .setApikey("apikey")
                .setApiurl("apiurl")
                .setEid(eid)
                .setEcode("ecode")
                .setEurl("eurl");

        String[] ebids = new String[]{"ebid1", "ebid2"};
        if (eid.equals("cardList")) {
            apiConfig.setEbid("cardList");
        } else if (eid.equals("eid")) {
            apiConfig.setEbid(ebids[Math.abs(RandomUtil.getRandom().nextInt()) % 2]);
        } else {
            apiConfig.setEbid("cardListEbid");
        }

        return apiConfig;
    }

    /**
     * 执行调用
     *
     * @param config
     * @param p
     * @return
     */
    @Override
    public R process(ApiConfig config, P p) {
        String name = this.getClass().getAnnotation(ApiService.class).name();
        log.info(name + "调用开始");
        IApiDao apidao = apiDaoManager.getApiDao(config);
        R result = (R) apidao.process(config, p);
        log.info(name + "调用结束" + JSONUtil.toJsonStr(result));
        return result;
    }
}
