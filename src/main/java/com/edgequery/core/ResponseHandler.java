package com.edgequery.core;

public interface ResponseHandler<S extends Response, T> {
    T handler(Env env, S res);
}
