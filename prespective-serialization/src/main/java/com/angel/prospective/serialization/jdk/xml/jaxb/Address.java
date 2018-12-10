package com.angel.prospective.serialization.jdk.xml.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Address {
    private Integer id;
    private String province;
    private String city;
    private String area;
    private String other;

    @XmlAttribute(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @XmlElement
    public String getProvince() {
        return province;
    }


    public void setProvince(String province) {
        this.province = province;
    }

    @XmlElement
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @XmlElement
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

}