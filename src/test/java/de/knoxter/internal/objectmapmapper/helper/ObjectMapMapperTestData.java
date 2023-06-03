package de.knoxter.internal.objectmapmapper.helper;

import java.util.HashMap;
import java.util.Map;

import de.knoxter.internal.objectmapmapper.helper.testdata.InnerObjectTestClass;
import de.knoxter.internal.objectmapmapper.helper.testdata.MultipleInnerObjectTestClass;
import de.knoxter.internal.objectmapmapper.helper.testdata.PrimitiveArrayTestClass;
import de.knoxter.internal.objectmapmapper.helper.testdata.PrimitiveTestClass;
import de.knoxter.internal.objectmapmapper.helper.testdata.WrapperArrayTestClass;
import de.knoxter.internal.objectmapmapper.helper.testdata.WrapperListTestClass;
import de.knoxter.internal.objectmapmapper.helper.testdata.WrapperMapTestClass;
import de.knoxter.internal.objectmapmapper.helper.testdata.WrapperTestClass;

public abstract class ObjectMapMapperTestData {
    public static Object empty() {
        return new Object();
    }

    public static Map<String, Object> emptyExpected() {
        return new HashMap<String, Object>();
    }

    public static Object primitive() {
        return PrimitiveTestClass.filled();
    }

    public static Map<String, Object> primitiveExpected() {
        PrimitiveTestClass obj = (PrimitiveTestClass)primitive();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("primByte", obj.getPrimByte());
        map.put("primShort", obj.getPrimShort());
        map.put("primInt", obj.getPrimInt());
        map.put("primLong", obj.getPrimLong());
        map.put("primFloat", obj.getPrimFloat());
        map.put("primDouble", obj.getPrimDouble());
        return map;
    }

    public static Object primitiveArray() {
        return PrimitiveArrayTestClass.filled();
    }

    public static Map<String, Object> primitiveArrayExpected() {
        PrimitiveArrayTestClass obj = (PrimitiveArrayTestClass)primitiveArray();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("primByteArray", obj.getPrimByteArray());
        map.put("primShortArray", obj.getPrimShortArray());
        map.put("primIntArray", obj.getPrimIntArray());
        map.put("primLongArray", obj.getPrimLongArray());
        map.put("primFloatArray", obj.getPrimFloatArray());
        map.put("primDoubleArray", obj.getPrimDoubleArray());
        return map;
    }

    public static Object wrapper() {
        return WrapperTestClass.filled();
    }

    public static Map<String, Object> wrapperExpected() {
        WrapperTestClass obj = (WrapperTestClass)wrapper();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("wrapperByte", obj.getWrapperByte());
        map.put("wrapperShort", obj.getWrapperShort());
        map.put("wrapperInt", obj.getWrapperInt());
        map.put("wrapperLong", obj.getWrapperLong());
        map.put("wrapperFloat", obj.getWrapperFloat());
        map.put("wrapperDouble", obj.getWrapperDouble());
        return map;
    }

    public static Map<String, Object> wrapperExpectedIncrement(int increment) {
        WrapperTestClass obj = (WrapperTestClass)wrapper();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("wrapperByte", obj.getWrapperByte() + increment);
        map.put("wrapperShort", obj.getWrapperShort() + increment);
        map.put("wrapperInt", obj.getWrapperInt() + increment);
        map.put("wrapperLong", obj.getWrapperLong() + increment);
        map.put("wrapperFloat", obj.getWrapperFloat() + increment);
        map.put("wrapperDouble", obj.getWrapperDouble() + increment);
        return map;
    }

    public static Object wrapperArray() {
        return WrapperArrayTestClass.filled();
    }

    public static Map<String, Object> wrapperArrayExpected() {
        WrapperArrayTestClass obj = (WrapperArrayTestClass)wrapperArray();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("wrapperByteArray", obj.getWrapperByteArray());
        map.put("wrapperShortArray", obj.getWrapperShortArray());
        map.put("wrapperIntArray", obj.getWrapperIntArray());
        map.put("wrapperLongArray", obj.getWrapperLongArray());
        map.put("wrapperFloatArray", obj.getWrapperFloatArray());
        map.put("wrapperDoubleArray", obj.getWrapperDoubleArray());
        return map;
    }

    public static Object wrapperList() {
        return WrapperListTestClass.filled();
    }

    public static Map<String, Object> wrapperListExpected() {
        WrapperListTestClass obj = (WrapperListTestClass)wrapperList();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("wrapperByteList", obj.getWrapperByteList());
        map.put("wrapperShortList", obj.getWrapperShortList());
        map.put("wrapperIntList", obj.getWrapperIntList());
        map.put("wrapperLongList", obj.getWrapperLongList());
        map.put("wrapperFloatList", obj.getWrapperFloatList());
        map.put("wrapperDoubleList", obj.getWrapperDoubleList());
        return map;
    }

    public static Object wrapperMap() {
        return WrapperMapTestClass.filled();
    }

    public static Map<String, Object> wrapperMapExpected() {
        WrapperMapTestClass obj = (WrapperMapTestClass)wrapperMap();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("wrapperByteMap", obj.getWrapperByteMap());
        map.put("wrapperShortMap", obj.getWrapperShortMap());
        map.put("wrapperIntegerMap", obj.getWrapperIntegerMap());
        map.put("wrapperLongMap", obj.getWrapperLongMap());
        map.put("wrapperFloatMap", obj.getWrapperFloatMap());
        map.put("wrapperDoubleMap", obj.getWrapperDoubleMap());
        return map;
    }

    public static Object innerObject() {
        return InnerObjectTestClass.filled();
    }

    public static Map<String, Object> innerObjectExpected() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("primitive", primitiveExpected());
        map.put("primitiveArray", primitiveArrayExpected());
        map.put("wrapper", wrapperExpected());
        map.put("wrapperArray", wrapperArrayExpected());
        map.put("wrapperList", wrapperListExpected());
        map.put("wrapperMap", wrapperMapExpected());
        return map;
    }

    public static Object multipleInnerObject() {
        return MultipleInnerObjectTestClass.filled();
    }

    public static Map<String, Object> multipleInnerObjectExpected() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("a", innerObjectExpected());
        map.put("b", innerObjectExpected());
        return map;
    }
}
