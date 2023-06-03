package de.knoxter.internal.objectmapmapper.helper;

import de.knoxter.internal.objectmapmapper.IPropertyConverter;

public class TestPropertyConverter implements IPropertyConverter {
    @Override
    public Object convert(Object object) {
        if(object instanceof String)
            return ((String)object) + "1";
        if(object instanceof Integer)
            return (int)object +1;
        return null;
    }  
}
