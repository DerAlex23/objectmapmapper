package de.knoxter.internal.objectmapmapper.helper.testdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WrapperArrayTestClass {
    private Byte[] wrapperByteArray;
    private Short[] wrapperShortArray;
    private Integer[] wrapperIntArray;
    private Long[] wrapperLongArray;
    private Float[] wrapperFloatArray;
    private Double[] wrapperDoubleArray;

    public static WrapperArrayTestClass empty() {
        return new WrapperArrayTestClass();
    }

    public static WrapperArrayTestClass filled() {
        WrapperArrayTestClass container = new WrapperArrayTestClass();
        container.wrapperByteArray = new Byte[]{ 10, 11, 12 };
        container.wrapperShortArray = new Short[]{ 20, 21, 22 };
        container.wrapperIntArray = new Integer[]{ 30, 31, 32 };
        container.wrapperLongArray = new Long[]{ 40L, 41L, 42L };
        container.wrapperFloatArray = new Float[]{ 50.5f, 51.51f, 52.52f };
        container.wrapperDoubleArray = new Double[]{ 60.6, 61.61, 62.62 };
        return container;
    }
}
