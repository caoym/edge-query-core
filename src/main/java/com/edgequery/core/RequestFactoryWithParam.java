package com.edgequery.core;

import java.util.function.BiFunction;

/**
 * Created by caoyangmin on 2018/3/24.
 */

public interface RequestFactoryWithParam<R extends Request<S> ,S extends Response, V> {
    R create(Env env, V param);
}
