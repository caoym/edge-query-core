package com.edgequery.core;

public interface Env {
    <T> T getBean(Class<T> tClass);
}
