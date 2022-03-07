package com.example.demo.jaxb;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author linkun
 * @date 2022/3/7 15:18
 */
@XmlRootElement(name = "Envelope", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {
    @XmlElement(name = "Body", namespace = "http://schemas.xmlsoap.org/soap/envelope/")
    @Getter
    @Setter
    private Body body;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    public static class Body {
        @XmlElement(name = "GetModifiedTerminalsResponse", namespace = "http://api.jasperwireless.com/ws/schema")
        private GetModifiedTerminalsResponse getModifiedTerminalsResponse;

        @XmlAccessorType(XmlAccessType.FIELD)
        @Data
        public static class GetModifiedTerminalsResponse {
            @XmlElement(name = "iccids", namespace = "http://api.jasperwireless.com/ws/schema")
            private Iccids iccids;

            @XmlElement(name = "totalPages", namespace = "http://api.jasperwireless.com/ws/schema")
            private Integer totalPage;

            @XmlAccessorType(XmlAccessType.FIELD)
            @Data
            public static class Iccids {
                @XmlElement(name = "iccid", namespace = "http://api.jasperwireless.com/ws/schema")
                private List<String> iccid;

            }
        }
    }

}
