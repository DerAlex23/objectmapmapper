package de.knoxter.internal.objectmapmapper;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.knoxter.internal.objectmapmapper.exception.AutoMapperException;
import de.knoxter.internal.reflectutils.ReflectUtils;

/**
 * Maps properties into a map (String -> Object). You may define which
 * properties should be added (whitelist) or which should be ignored
 * (blacklist) and of course, it has a property auto-detect feature.
 * It also provides the possibility to change properties name or their
 * values.
 */
public class ObjectMapMapper {
    private static final List<Class<?>> wrapperClasses = Arrays.asList(new Class[] {
        Boolean.class, Byte.class, Character.class, Short.class,
        Integer.class, Long.class, Double.class, Float.class, String.class
    });
    private Map<Class<?>, Map<String, Method>> cachedGetters = new HashMap<Class<?>, Map<String, Method>>();
    private ObjectMapMapperConfig defaultConfig;
    private Map<Class<?>, ObjectMapMapperConfig> classConfigs = new HashMap<Class<?>, ObjectMapMapperConfig>();

    /**
     * Creates a new mapper with the provided configuration as default.
     * @param config Mapper configuration.
     */
    public ObjectMapMapper(ObjectMapMapperConfig config) {
        this.defaultConfig = config;
    }

    /**
     * Creates a new mapper with the default configuration.
     */
    public ObjectMapMapper() {
        this(new ObjectMapMapperConfig());
    }

    /**
     * Sets a mapping configuration for a specific class.
     * @param clazz Class to which this configuration should apply.
     * @param config The mapping configuration for the class.
     */
    public void setClassConfig(Class<?> clazz, ObjectMapMapperConfig config) {
        classConfigs.put(clazz, config);
    }

    /**
     * Gets a mapping configuration for a specific class.
     * @param clazz Class of which you want to get the configuration.
     * @return The appropriate configuration or null.
     */
    public ObjectMapMapperConfig getClassConfig(Class<?> clazz) {
        return classConfigs.get(clazz);
    }

    /**
     * Maps an object to a map.
     * @param object Objet to map.
     * @return Map which contains the properties' names as key and their corresponding values as value.
     * @throws AutoMapperException Is thrown when a property could not be accessed.
     */
    public Map<String, Object> objectToMap(Object object) throws AutoMapperException {
        Object convertedObject = convertObjectToMap(object, "");
        if(convertedObject instanceof Map)
            return (Map)convertedObject;
        return null;
    }

    private Object convertObjectToMap(Object object, String path) throws AutoMapperException {
        if(object == null)
            return null;
        Class<?> clazz = object.getClass();
        if(clazz.isPrimitive() || wrapperClasses.contains(clazz))
            return object;
        if(object instanceof List)
            return convertList(object, path);
        if(object.getClass().isArray())
            return convertArray(object, path);
        if(object instanceof Map)
            return convertMap(object, path);
        ObjectMapMapperConfig config = getConfigForClass(clazz);
        return convertObjectsPropertiesToMap(object, path, clazz, config);
    }

    private ObjectMapMapperConfig getConfigForClass(Class<?> clazz) {
        return classConfigs.containsKey(clazz) ? classConfigs.get(clazz) : defaultConfig;
    }

    private Object convertObjectsPropertiesToMap(Object object, String path, Class<?> clazz, ObjectMapMapperConfig config) throws AutoMapperException {
        Map<String, Method> getters = getPropertyGetters(clazz);
        List<String> keysToMap = getKeysToMap(getters, config);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        for (String key : keysToMap) {
            Object value;
            try {
                value = getters.get(key).invoke(object);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new AutoMapperException("Could not read source property '" + key + "': " + e.getMessage(), e);
            }
            String keyPath = path.length() > 0 ? path + "." + key : key;
            if(config.getConverters().containsKey(keyPath))
                value = config.getConverters().get(keyPath).convert(value);
            if(config.getSourceTargetMap().containsKey(keyPath))
                key = config.getSourceTargetMap().get(keyPath);
            resultMap.put(key, convertObjectToMap(value, keyPath));
        }
        return resultMap;
    }
    
    private Map<String, Method> getPropertyGetters(Class<?> clazz) {
        if(cachedGetters.containsKey(clazz))
            return cachedGetters.get(clazz);
        Map<String, Method> getters = ReflectUtils.getMethodNameMap(clazz, "get");
        getters.remove("class");
        getters.remove("");
        cachedGetters.put(clazz, getters);
        return getters;
    }

    private List<String> getKeysToMap(Map<String, Method> sourceGetters, ObjectMapMapperConfig config) {
        List<String> keysToMap = new ArrayList<String>();
        for (String key : sourceGetters.keySet()) {
            if((config.isMapAllProperties() && !config.getPropertiesToIgnore().contains(key)) ||
                config.getPropertiesToMap().contains(key))
                keysToMap.add(key);
        }
        return keysToMap;
    }

    private Object convertMap(Object object, String path) throws AutoMapperException {
        Map<String, Object> converted = new HashMap<String, Object>();
        Map<String, Object> casted = (Map)object;
        for (String key : casted.keySet())
            converted.put(key, convertObjectToMap(casted.get(key), path));
        return converted;
    }

    private Object convertArray(Object object, String path) throws AutoMapperException {
        Object converted = Array.newInstance(object.getClass().getComponentType(), Array.getLength(object));
        for (int i = 0; i < Array.getLength(object); i++)
            Array.set(converted, i, convertObjectToMap(Array.get(object, i), path));
        return converted;
    }

    private Object convertList(Object object, String path) throws AutoMapperException {
        List<Object> converted = new ArrayList<Object>();
        List<Object> casted = (List)object;
        for (int i = 0; i < casted.size(); i++)
            converted.add(convertObjectToMap(casted.get(i), path));
        return converted;
    }
}
