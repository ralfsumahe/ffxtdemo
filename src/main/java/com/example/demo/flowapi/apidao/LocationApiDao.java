package com.example.demo.flowapi.apidao;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.CNoParam;
import com.example.demo.flowapi.ability.vo.LocationResult;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/18 15:20
 */
@Component
@ApiDao(eid = "10002", syncType = "小米")
public class LocationApiDao implements IApiDao<CNoParam, LocationResult> {
    @Override
    public LocationResult process(ApiConfig apiConfig, CNoParam cNoParam) {
        return new LocationResult().setLon(1).setLat(2);
    }
}
