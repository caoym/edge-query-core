package com.edgequery.core;

import com.edgequery.core.flow.Flow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by caoyangmin on 2018/3/28.
 */
public interface Dispatcher {
    <T> Future<T> dispatch(Flow reqG);
}
