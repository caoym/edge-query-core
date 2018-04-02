package com.edgequery.core.utils;

import java.lang.reflect.InvocationTargetException;

public class AssertEx {

    public static<T extends Exception> void isTrue(boolean expression, String message, Class<T> exception) throws T {
        if (!expression) {
            try {
                throw exception.getDeclaredConstructor(String.class).newInstance(message);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
