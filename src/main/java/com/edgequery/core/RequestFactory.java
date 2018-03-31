package com.edgequery.core;

import java.io.Serializable;

/**
 * Created by caoyangmin on 2018/3/24.
 */

public interface RequestFactory<R extends Request<S> ,S extends Response> extends Serializable {
    R create(Env env);
}
