package com.edgequery.core;


import com.edgequery.core.flow.FlowBuilder;
import com.edgequery.core.flow.FlowScheduler;
import com.edgequery.core.flow.Node;
import com.edgequery.core.flow.RequestTask;
import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.util.concurrent.ExecutionException;

@NotThreadSafe
final public class EdgeQueryClient {

    @Nonnull
    final private FlowScheduler scheduler;

    public EdgeQueryClient(@Nonnull FlowScheduler scheduler){
        this.scheduler = scheduler;
    }

    public class ThenRequest<T>{

        final private FlowBuilder flowBuilder;
        final private Node node;

        ThenRequest(@Nonnull FlowBuilder flowBuilder, @Nonnull Node node) {

            this.flowBuilder = flowBuilder;
            this.node = node;
        }

        public <R extends Request<S> ,S extends Response> ThenResponse<S> thenRequest(
                @Nonnull RequestFactory<R, S, T> requestFactory) {

            return EdgeQueryClient.this.request(flowBuilder, requestFactory);
        }

        public T execute() throws ExecutionException, InterruptedException {

            //send RequestGraph;
            return (T)EdgeQueryClient.this.dispatcher.dispatch(flowBuilder.build()).get();
        }
    }

    public class ThenResponse<S extends Response>{

        final private FlowBuilder flowBuilder;
        final private RequestTask requestTask;

        ThenResponse(@Nonnull FlowBuilder flowBuilder, @Nonnull RequestTask requestTask) {

            this.flowBuilder = flowBuilder;
            this.requestTask = requestTask;
        }

        @Nonnull
        public <T> ThenRequest<T> then(@Nonnull ResponseHandler<S, T> responseHandler){

            Preconditions.checkNotNull(responseHandler);

            requestTask.setResponseHandler(responseHandler);
            return new ThenRequest<T>(flowBuilder, requestTask);
        }
    }


    @Nonnull
    public <R extends Request<S> , S extends Response>
    ThenResponse<S> request(@Nonnull RequestFactoryNonParam<R, S> requestFactory) {
        FlowBuilder flowBuilder = new FlowBuilder();
        return request(flowBuilder, requestFactory);
    }


    @Nonnull
    private  <R extends Request<S> , S extends Response, T>
    ThenResponse<S> request(@Nonnull FlowBuilder flowBuilder, @Nonnull RequestFactory<R, S, T> requestFactory) {

        Preconditions.checkNotNull(flowBuilder);
        Preconditions.checkNotNull(requestFactory);

        RequestTask task = flowBuilder.begin().connect(requestFactory);
        return new ThenResponse<S>(flowBuilder, task);
    }

    private void execute(){

    }

}
