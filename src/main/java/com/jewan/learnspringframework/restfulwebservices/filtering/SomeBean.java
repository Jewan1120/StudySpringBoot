package com.jewan.learnspringframework.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties({ "field1", "field4" }) // 클래스에 직접 무시할 변수 정의 가능
@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;

    @JsonIgnore // Json에 해당 변수를 포함시키지 않음
    private String field2;
    private String field3;
    

    public SomeBean(String field1, String field2, String field3) {
        super();
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
    }

}
