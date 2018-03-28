package com.edgequery.core;

public interface Request<S extends Response>
{
    <T> Request<S> then(ResponseHandler<S, T> responseHandler);
}
