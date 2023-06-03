package de.knoxter.internal.objectmapmapper.helper.testdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class InnerObjectTestClass {
    private PrimitiveTestClass primitive;
    private PrimitiveArrayTestClass primitiveArray;
    private WrapperTestClass wrapper;
    private WrapperArrayTestClass wrapperArray;
    private WrapperListTestClass wrapperList;
    private WrapperMapTestClass wrapperMap;

    public static InnerObjectTestClass empty() {
        return new InnerObjectTestClass();
    }

    public static InnerObjectTestClass filled() {
        InnerObjectTestClass obj = new InnerObjectTestClass();
        obj.setPrimitive(PrimitiveTestClass.filled());
        obj.setPrimitiveArray(PrimitiveArrayTestClass.filled());
        obj.setWrapper(WrapperTestClass.filled());
        obj.setWrapperArray(WrapperArrayTestClass.filled());
        obj.setWrapperList(WrapperListTestClass.filled());
        obj.setWrapperMap(WrapperMapTestClass.filled());
        return obj;
    }
}
