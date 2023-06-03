package de.knoxter.internal.objectmapmapper.helper.testdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PrimitiveTestClass {
    private byte primByte;
    private short primShort;
    private int primInt;
    private long primLong;
    private float primFloat;
    private double primDouble;

    public static PrimitiveTestClass empty() {
        return new PrimitiveTestClass();
    }

    public static PrimitiveTestClass filled() {
        PrimitiveTestClass obj = new PrimitiveTestClass();
        obj.primByte = 10;
        obj.primShort = 20;
        obj.primInt = 30;
        obj.primLong = 40;
        obj.primFloat = 50.5f;
        obj.primDouble = 60.6;
        return obj;
    }
}
