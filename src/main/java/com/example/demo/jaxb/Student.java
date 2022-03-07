package com.example.demo.jaxb;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author linkun
 * @date 2022/3/7 14:03
 */
@XmlRootElement(namespace = "http://www.w3cschool.org/jaxb2/")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@Accessors(chain = true)
public class Student {
    @XmlElement(namespace = "http://www.baidu.com/")
    private String id;
    private String name;
    @XmlElement(namespace = "http://www.w3cschool.org/jaxb2/")
    private Integer age;
}
