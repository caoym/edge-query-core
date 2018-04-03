package com.edgequery.core;

import javax.annotation.Nonnull;

public interface ResponseFuture<P extends Response>{

    @Nonnull <R> RequestFuture<R> then(@Nonnull ResponseHandler<P, R> responseHandler);
}

