package de.knoxter.internal.objectmapmapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import de.knoxter.internal.objectmapmapper.IPropertyConverter;
import de.knoxter.internal.objectmapmapper.ObjectMapMapper;
import de.knoxter.internal.objectmapmapper.ObjectMapMapperConfig;
import de.knoxter.internal.objectmapmapper.exception.AutoMapperException;
import de.knoxter.internal.objectmapmapper.helper.ObjectMapMapperTestData;
import de.knoxter.internal.objectmapmapper.helper.testdata.TestConverter;

public class ObjectMapMapperTests {
    // TODO: check deeper paths for converter and source-target-mapping
    @Test
    public void empty_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.emptyExpected();
        Object obj = ObjectMapMapperTestData.empty();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void caching_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.primitiveExpected();
        Object obj = ObjectMapMapperTestData.primitive();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        Map<String, Object> second = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
        assertMapEquals(expected, second);
    }

    @Test
    public void primitive_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.primitiveExpected();
        Object obj = ObjectMapMapperTestData.primitive();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }
    
    @Test
    public void primitiveArray_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.primitiveArrayExpected();
        Object obj = ObjectMapMapperTestData.primitiveArray();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void wrapper_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.wrapperExpected();
        Object obj = ObjectMapMapperTestData.wrapper();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void wrapperArray_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.wrapperArrayExpected();
        Object obj = ObjectMapMapperTestData.wrapperArray();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void wrapperList_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.wrapperListExpected();
        Object obj = ObjectMapMapperTestData.wrapperList();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void wrapperMap_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.wrapperMapExpected();
        Object obj = ObjectMapMapperTestData.wrapperMap();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void innerObject_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.innerObjectExpected();
        Object obj = ObjectMapMapperTestData.innerObject();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void multipleInnerObject_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapper mapper = getDefaultMapper();
        Map<String, Object> expected = ObjectMapMapperTestData.multipleInnerObjectExpected();
        Object obj = ObjectMapMapperTestData.multipleInnerObject();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void mapNoProperties_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapperConfig cfg = new ObjectMapMapperConfig();
        cfg.setMapAllProperties(false);
        ObjectMapMapper mapper = new ObjectMapMapper(cfg);
        Map<String, Object> expected = new HashMap<String, Object>();
        Object obj = ObjectMapMapperTestData.primitive();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void mapSpecificProperty_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapperConfig cfg = new ObjectMapMapperConfig();
        cfg.setMapAllProperties(false);
        cfg.getPropertiesToMap().add("primByte");
        cfg.getPropertiesToMap().add("primLong");
        ObjectMapMapper mapper = new ObjectMapMapper(cfg);
        Map<String, Object> expected = ObjectMapMapperTestData.primitiveExpected();
        expected.remove("primShort");
        expected.remove("primInt");
        expected.remove("primFloat");
        expected.remove("primDouble");
        Object obj = ObjectMapMapperTestData.primitive();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void mapIgnoredProperty_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapperConfig cfg = new ObjectMapMapperConfig();
        cfg.getPropertiesToIgnore().add("primByte");
        cfg.getPropertiesToIgnore().add("primLong");
        ObjectMapMapper mapper = new ObjectMapMapper(cfg);
        Map<String, Object> expected = ObjectMapMapperTestData.primitiveExpected();
        expected.remove("primByte");
        expected.remove("primLong");
        Object obj = ObjectMapMapperTestData.primitive();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void mapSourceTargetProperty_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapperConfig cfg = new ObjectMapMapperConfig();
        cfg.getSourceTargetMap().put("primByte", "movedPrimByte");
        cfg.getSourceTargetMap().put("primLong", "movedPrimLong");
        ObjectMapMapper mapper = new ObjectMapMapper(cfg);
        Map<String, Object> expected = ObjectMapMapperTestData.primitiveExpected();
        expected.put("movedPrimByte", expected.get("primByte"));
        expected.put("movedPrimLong", expected.get("primLong"));
        expected.remove("primByte");
        expected.remove("primLong");
        Object obj = ObjectMapMapperTestData.primitive();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    @Test
    public void mapConverterProperty_shouldSucceed() throws AutoMapperException {
        // prepare
        ObjectMapMapperConfig cfg = new ObjectMapMapperConfig();
        IPropertyConverter converter = new TestConverter(1);
        cfg.getConverters().put("wrapperByte", converter);
        cfg.getConverters().put("wrapperShort", converter);
        cfg.getConverters().put("wrapperInt", converter);
        cfg.getConverters().put("wrapperLong", converter);
        cfg.getConverters().put("wrapperFloat", converter);
        cfg.getConverters().put("wrapperDouble", converter);
        ObjectMapMapper mapper = new ObjectMapMapper(cfg);
        Map<String, Object> expected = ObjectMapMapperTestData.wrapperExpectedIncrement(1);
        Object obj = ObjectMapMapperTestData.wrapper();
        // test
        Map<String, Object> actual = mapper.objectToMap(obj);
        // validate
        assertMapEquals(expected, actual);
    }

    private void assertMapEquals(Map<String, Object> expected, Map<String, Object> actual) {
        if(expected.size() != actual.size())
            throw new org.opentest4j.AssertionFailedError("Acutal map size " + actual.size() + " is not equal not expected size " + expected.size());
        for (String key : expected.keySet()) {
            if(!actual.containsKey(key))
                throw new org.opentest4j.AssertionFailedError("Acutal map does not have expected key " + key);
            Object expectedObj = expected.get(key);
            Object actualObj = actual.get(key);
            if(expectedObj.getClass().isArray()) {
                assertTrue(actualObj.getClass().isArray() || actualObj == null);
                assertEquals(Array.getLength(expectedObj), Array.getLength(actualObj));
                for (int i = 0; i < Array.getLength(expectedObj); i++)
                    assertEquals(Array.get(expectedObj, i), Array.get(actualObj, i));
            }
            else if(expectedObj instanceof List) {
                assertTrue(actualObj instanceof List || actualObj == null);
                assertEquals(((List)expectedObj).size(), ((List)actualObj).size());
                for (int i = 0; i < ((List)expectedObj).size(); i++)
                    assertEquals(((List)expectedObj).get(i), ((List)expectedObj).get(i));
            }
            else if(expectedObj instanceof Map) {
                assertTrue(actualObj instanceof Map || actualObj == null);
                assertMapEquals((Map)expectedObj, (Map)actualObj);
            }
            else {
                assertEquals(expectedObj, actualObj);
            }
        }
    }

    private ObjectMapMapper getDefaultMapper() {
        return new ObjectMapMapper(new ObjectMapMapperConfig());
    }
}
