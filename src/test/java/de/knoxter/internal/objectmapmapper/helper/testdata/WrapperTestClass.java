package de.knoxter.internal.objectmapmapper.helper.testdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WrapperTestClass {
    private Byte wrapperByte;
    private Short wrapperShort;
    private Integer wrapperInt;
    private Long wrapperLong;
    private Float wrapperFloat;
    private Double wrapperDouble;

    public static WrapperTestClass empty() {
        return new WrapperTestClass();
    }

    public static WrapperTestClass filled() {
        WrapperTestClass obj = new WrapperTestClass();
        obj.wrapperByte = 110;
        obj.wrapperShort = 120;
        obj.wrapperInt = 130;
        obj.wrapperLong = 140L;
        obj.wrapperFloat = 150.15f;
        obj.wrapperDouble = 160.16;
        return obj;
    }
}
