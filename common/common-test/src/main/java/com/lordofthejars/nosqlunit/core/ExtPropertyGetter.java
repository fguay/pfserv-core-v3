package com.lordofthejars.nosqlunit.core;


import java.lang.reflect.Field;


/**
 * A soumettre à nosqlunit
 * */
public class ExtPropertyGetter <T> extends PropertyGetter<T> {

    public T propertyByType(Object testInstance, Class<T> type) {
        if(testInstance != null) {
            Field field = propertyByType(testInstance.getClass(), type);
            if(field != null){
                return (T) new FieldGetter(testInstance, field).get();
            }
        }
        return null;
    }

    public Field propertyByType(final Class clazz, final Class<T> type) {

       if(clazz != null){
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                if (field.getType().isAssignableFrom(type)) {
                    return field;
                }
            }
            return propertyByType(clazz.getSuperclass(), type);
        }
        return null;
    }

}
