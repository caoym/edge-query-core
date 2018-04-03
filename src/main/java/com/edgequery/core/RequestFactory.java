package com.edgequery.core;

import java.io.Serializable;

/**
 * Created by caoyangmin on 2018/3/24.
 */

public interface RequestFactory<Q extends Request<P> ,P extends Response, R> {
    Q create(Env env, R param);
}
