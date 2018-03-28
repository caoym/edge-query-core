package com.edgequery.core;

public interface RequestFactoryWithParam<R extends Request<S> ,S extends Response, V> {

    R create(V param);
}