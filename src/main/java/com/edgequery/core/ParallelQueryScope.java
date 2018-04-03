package com.edgequery.core;

import javax.annotation.Nonnull;

public interface ParallelQueryScope{

    /**
     * 发起单个异步请求
     */
    @Nonnull
    <R extends Request<S> , S extends Response>
    ResponseFuture<S> request(@Nonnull RequestFactoryNonParam<R, S> requestFactory);

}
