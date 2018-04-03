package com.edgequery.core;

import java.util.List;

public interface ParallelRequestsFactory<R> {

    void create(RequestFuture<R> scope, R param);
}
