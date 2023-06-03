package de.knoxter.internal.objectmapmapper.helper.testdata;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class MultipleInnerObjectTestClass {
    private InnerObjectTestClass a;
    private InnerObjectTestClass b;

    public static MultipleInnerObjectTestClass empty() {
        return new MultipleInnerObjectTestClass();
    }

    public static MultipleInnerObjectTestClass filled() {
        MultipleInnerObjectTestClass obj = new MultipleInnerObjectTestClass();
        obj.setA(InnerObjectTestClass.filled());
        obj.setB(InnerObjectTestClass.filled());
        return obj;
    }
}
