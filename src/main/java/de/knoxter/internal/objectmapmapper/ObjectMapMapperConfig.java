package de.knoxter.internal.objectmapmapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Configuration which provides features for the property mapping.
 */
public class ObjectMapMapperConfig {
    private boolean mapAllProperties = true;
    private List<String> propertiesToMap = new ArrayList<String>();
    private List<String> propertiesToIgnore = new ArrayList<String>();
    private Map<String, String> sourceTargetMap = new HashMap<String, String>();
    private Map<String, IPropertyConverter> converters = new HashMap<String, IPropertyConverter>();

    /**
     * Defines whether or not to auto-map all properties (except for the ignored ones)
     */
    public boolean isMapAllProperties() {
        return mapAllProperties;
    }
    /**
     * Defines whether or not to auto-map all properties (except for the ignored ones)
     */
    public ObjectMapMapperConfig setMapAllProperties(boolean mapAllProperties) {
        this.mapAllProperties = mapAllProperties;
        return this;
    }
    
    /**
     * Specifies which properties should be mapped. If you use this, make sure to set
     * "mapAllProperties" to false.
     */
    public List<String> getPropertiesToMap() {
        return propertiesToMap;
    }
    /**
     * Specifies which properties should be mapped. If you use this, make sure to set
     * "mapAllProperties" to false.
     */
    public ObjectMapMapperConfig setPropertiesToMap(List<String> propertiesToMap) {
        this.propertiesToMap = propertiesToMap;
        return this;
    }
    /**
     * Specifies which properties should be mapped. If you use this, make sure to set
     * "mapAllProperties" to false.
     */
    public ObjectMapMapperConfig mapProperty(String property) {
        propertiesToMap.add(property);
        return this;
    }
    /**
     * Specifies which properties should be mapped. If you use this, make sure to set
     * "mapAllProperties" to false.
     */
    public ObjectMapMapperConfig mapProperties(Iterable<String> properties) {
        for (String property : properties) 
            propertiesToMap.add(property);
        return this;
    }
    
    /**
     * Specifies which properties should be ignored in mapping. This will only affect
     * auto-mapped properties.
     */
    public List<String> getPropertiesToIgnore() {
        return propertiesToIgnore;
    }
    /**
     * Specifies which properties should be ignored in mapping. This will only affect
     * auto-mapped properties.
     */
    public ObjectMapMapperConfig setPropertiesToIgnore(List<String> propertiesToIgnore) {
        this.propertiesToIgnore = propertiesToIgnore;
        return this;
    }
    /**
     * Specifies which properties should be ignored in mapping. This will only affect
     * auto-mapped properties.
     */
    public ObjectMapMapperConfig ignoreProperty(String property) {
        propertiesToIgnore.add(property);
        return this;
    }
    /**
     * Specifies which properties should be ignored in mapping. This will only affect
     * auto-mapped properties.
     */
    public ObjectMapMapperConfig ignoreProperties(Iterable<String> properties) {
        for (String property : properties) 
        propertiesToIgnore.add(property);
        return this;
    }
    
    /**
     * By default a target propertys name is the same as the source propertys name. If
     * the target name should differ, add the path of the property as key and the new
     * propertys name as value to this map. Improtant notice: the path of a property
     * is not necesarily the same as the propertys name - it also consits of all parent
     * properties' names connected by a dot (.), e.g.: Class A has a property propA of
     * type B. Class B has a property probB of type int. If you map an object of type B
     * and want to change "probB" to "probC" the path would be "probB", but if you map
     * an object of type A, the path would be "probA.proB".
     */
    public Map<String, String> getSourceTargetMap() {
        return sourceTargetMap;
    }
    /**
     * By default a target propertys name is the same as the source propertys name. If
     * the target name should differ, add the path of the property as key and the new
     * propertys name as value to this map. Improtant notice: the path of a property
     * is not necesarily the same as the propertys name - it also consits of all parent
     * properties' names connected by a dot (.), e.g.: Class A has a property propA of
     * type B. Class B has a property probB of type int. If you map an object of type B
     * and want to change "probB" to "probC" the path would be "probB", but if you map
     * an object of type A, the path would be "probA.proB".
     */
    public ObjectMapMapperConfig setSourceTargetMap(Map<String, String> sourceTargetMap) {
        this.sourceTargetMap = sourceTargetMap;
        return this;
    }
    /**
     * By default a target propertys name is the same as the source propertys name. If
     * the target name should differ, add the path of the property as key and the new
     * propertys name as value to this map. Improtant notice: the path of a property
     * is not necesarily the same as the propertys name - it also consits of all parent
     * properties' names connected by a dot (.), e.g.: Class A has a property propA of
     * type B. Class B has a property probB of type int. If you map an object of type B
     * and want to change "probB" to "probC" the path would be "probB", but if you map
     * an object of type A, the path would be "probA.proB".
     */
    public ObjectMapMapperConfig addSourceTargetNameMapping(String sourcePath, String targetName) {
        sourceTargetMap.put(sourcePath, targetName);
        return this;
    }

    /**
     * In case you want the value of a property to be changed, you may add a implementation
     * of IPropertyConverter as value and the path to the property as key to this map.
     * Regarding property path: if you are unsure about the difference between property path
     * and property name, please have a look at the comment of the "setSourceTargetMap" method
     * where it is explained in detail.
     */
    public Map<String, IPropertyConverter> getConverters() {
        return converters;
    }
    /**
     * In case you want the value of a property to be changed, you may add a implementation
     * of IPropertyConverter as value and the path to the property as key to this map.
     * Regarding property path: if you are unsure about the difference between property path
     * and property name, please have a look at the comment of the "setSourceTargetMap" method
     * where it is explained in detail.
     */
    public ObjectMapMapperConfig setConverters(Map<String, IPropertyConverter> converters) {
        this.converters = converters;
        return this;
    }
    /**
     * In case you want the value of a property to be changed, you may add a implementation
     * of IPropertyConverter as value and the path to the property as key to this map.
     * Regarding property path: if you are unsure about the difference between property path
     * and property name, please have a look at the comment of the "setSourceTargetMap" method
     * where it is explained in detail.
     */
    public ObjectMapMapperConfig addConverter(String path, IPropertyConverter converter) {
        converters.put(path, converter);
        return this;
    }
}
