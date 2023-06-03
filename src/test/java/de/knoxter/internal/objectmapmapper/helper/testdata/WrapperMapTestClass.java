package de.knoxter.internal.objectmapmapper.helper.testdata;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class WrapperMapTestClass {
    private Map<String, Byte> wrapperByteMap = new HashMap<String, Byte>();
    private Map<String, Short> wrapperShortMap = new HashMap<String, Short>();
    private Map<String, Integer> wrapperIntegerMap = new HashMap<String, Integer>();
    private Map<String, Long> wrapperLongMap = new HashMap<String, Long>();
    private Map<String, Float> wrapperFloatMap = new HashMap<String, Float>();
    private Map<String, Double> wrapperDoubleMap = new HashMap<String, Double>();

    public static WrapperMapTestClass empty() {
        return new WrapperMapTestClass();
    }

    public static WrapperMapTestClass filled() {
        WrapperMapTestClass obj = new WrapperMapTestClass();
        obj.wrapperByteMap.put("bytes1", Byte.parseByte("1"));
        obj.wrapperByteMap.put("bytes2", Byte.parseByte("2"));
        obj.wrapperByteMap.put("bytes3", Byte.parseByte("3"));
        obj.wrapperShortMap.put("short1", Short.parseShort("1"));
        obj.wrapperShortMap.put("short2", Short.parseShort("2"));
        obj.wrapperShortMap.put("short3", Short.parseShort("3"));
        obj.wrapperIntegerMap.put("integer1", Integer.parseInt("1"));
        obj.wrapperIntegerMap.put("integer2", Integer.parseInt("2"));
        obj.wrapperIntegerMap.put("integer3", Integer.parseInt("3"));
        obj.wrapperLongMap.put("long1", Long.parseLong("1"));
        obj.wrapperLongMap.put("long2", Long.parseLong("2"));
        obj.wrapperLongMap.put("long3", Long.parseLong("3"));
        obj.wrapperFloatMap.put("float1", Float.parseFloat("1"));
        obj.wrapperFloatMap.put("float2", Float.parseFloat("2"));
        obj.wrapperFloatMap.put("float3", Float.parseFloat("3"));
        obj.wrapperDoubleMap.put("double1", Double.parseDouble("1"));
        obj.wrapperDoubleMap.put("double2", Double.parseDouble("2"));
        obj.wrapperDoubleMap.put("double3", Double.parseDouble("3"));
        return obj;
    }
}
