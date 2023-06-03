package de.knoxter.internal.objectmapmapper.helper.testdata;

import java.util.Arrays;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WrapperListTestClass {
    private List<Byte> wrapperByteList;
    private List<Short> wrapperShortList;
    private List<Integer> wrapperIntList;
    private List<Long> wrapperLongList;
    private List<Float> wrapperFloatList;
    private List<Double> wrapperDoubleList;

    public static WrapperListTestClass empty() {
        return new WrapperListTestClass();
    }

    public static WrapperListTestClass filled() {
        WrapperListTestClass obj = new WrapperListTestClass();
        obj.wrapperByteList = Arrays.asList(new Byte[]{ 10, 11, 12 });
        obj.wrapperShortList = Arrays.asList(new Short[]{ 20, 21, 22 });
        obj.wrapperIntList = Arrays.asList(new Integer[]{ 30, 31, 32 });
        obj.wrapperLongList = Arrays.asList(new Long[]{ 40L, 41L, 42L });
        obj.wrapperFloatList = Arrays.asList(new Float[]{ 50.5f, 51.51f, 52.52f });
        obj.wrapperDoubleList = Arrays.asList(new Double[]{ 60.6, 61.61, 62.62 });
        return obj;
    }
}
