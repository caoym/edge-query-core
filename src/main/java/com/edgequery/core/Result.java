package com.edgequery.core;


public interface Result<V> {
    boolean isSuccess();
    V getResult();
    Exception getException();
}
