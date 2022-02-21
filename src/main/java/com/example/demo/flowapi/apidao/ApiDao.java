package com.example.demo.flowapi.apidao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author linkun
 * @date 2022/2/16 15:43
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiDao {
    String eid();

    String oType();

    String syncType();
}
