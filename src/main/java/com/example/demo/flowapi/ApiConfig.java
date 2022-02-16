package com.example.demo.flowapi;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author linkun
 * @date 2022/2/16 15:07
 */
@Data
@Accessors(chain = true)
public class ApiConfig {
    private String eid;
    private String ebid;
    private String apiid;
    private String apikey;
    private String apiurl;
    private String ecode;
    private String eurl;
}
