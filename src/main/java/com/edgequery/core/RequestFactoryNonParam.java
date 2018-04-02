package com.edgequery.core;

import java.util.function.BiFunction;

public interface RequestFactoryNonParam<R extends Request<S> ,S extends Response>
        extends RequestFactory<R, S, Void>{

    default R create(Env env, Void v){
        return create(env);
    }
    R create(Env env);
}
