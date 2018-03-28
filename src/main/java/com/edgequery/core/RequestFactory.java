package com.edgequery.core;

/**
 * Created by caoyangmin on 2018/3/24.
 */

public interface RequestFactory<R extends Request<S> ,S extends Response> {
    R create();
}
