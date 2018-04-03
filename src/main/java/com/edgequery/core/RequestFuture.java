package com.edgequery.core;

import com.edgequery.core.flow.FlowBuilder;
import com.edgequery.core.flow.Node;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

public interface RequestFuture<R> {

    <Q extends Request<P> ,P extends Response> ResponseFuture<P> request(
            @Nonnull RequestFactory<Q, P, R> requestFactory);

    <Q extends Request<P> ,P extends Response> ResponseFuture<P> request(
            @Nonnull RequestFactoryNonParam<Q, P> requestFactory);

    RequestFuture<Result<?>[]> parallelRequests(ParallelRequestsFactory<R> praReqFactory);

}
