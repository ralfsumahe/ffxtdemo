package com.example.demo.flowapi.apidao;

import com.example.demo.flowapi.ApiConfig;
import com.example.demo.flowapi.ability.dto.LocationParam;
import com.example.demo.flowapi.ability.vo.LocationResult;
import org.springframework.stereotype.Component;

/**
 * @author linkun
 * @date 2022/2/18 15:20
 */
@Component
@ApiDao(eid = "10002", syncType = "小米", oType = "移动")
public class LocationApiDao implements IApiDao<LocationParam, LocationResult> {
    @Override
    public LocationResult process(ApiConfig apiConfig, LocationParam cNoParam) {
        return new LocationResult().setLon(1).setLat(2);
    }
}
