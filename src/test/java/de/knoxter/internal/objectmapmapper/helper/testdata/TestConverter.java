package de.knoxter.internal.objectmapmapper.helper.testdata;

import de.knoxter.internal.objectmapmapper.IPropertyConverter;

public class TestConverter implements IPropertyConverter {
    private final int increment;

    public TestConverter(int increment) {
        this.increment = increment;
    }

    @Override
    public Object convert(Object object) {
        if(object == null)
            return null;
        if(object instanceof Byte)
            return ((Byte)object) + increment;
        if(object instanceof Short)
            return ((Short)object) + increment;
        if(object instanceof Integer)
            return ((Integer)object) + increment;
        if(object instanceof Long)
            return ((Long)object) + increment;
        if(object instanceof Float)
            return ((Float)object) + increment;
        if(object instanceof Double)
            return ((Double)object) + increment;
        throw new RuntimeException("TestConverter doesnt support conversion of types '" + object.getClass() + "'!");
    }
}
