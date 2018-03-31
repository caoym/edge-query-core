package com.edgequery.core;


import java.util.concurrent.ExecutionException;

final public class EdgeQueryClient {

    final private Dispatcher dispatcher;

    public EdgeQueryClient(Dispatcher dispatcher){
        this.dispatcher = dispatcher;
    }
    public class ThenRequest<T>{

        final private RequestGraph graph;

        public ThenRequest(RequestGraph graph) {
            this.graph = graph;
        }

        public <R extends Request<S> ,S extends Response> ThenResponse<S> thenRequest(
                RequestFactoryWithParam<R, S, T> requestFactory) {
            graph.addRequest(requestFactory);
            return new ThenResponse<S>(graph);
        }

        public T execute() throws ExecutionException, InterruptedException {

            //send RequestGraph;

            return (T)EdgeQueryClient.this.dispatcher.dispatch(graph).get();
        }
    }

    public class ThenResponse<S extends Response>{

        final private RequestGraph graph;
        public ThenResponse(RequestGraph graph) {
            this.graph = graph;
        }

        public <T> ThenRequest<T> then(ResponseHandler<S, T> responseHandler){
            graph.addResponse(responseHandler);
            return new ThenRequest<T>(graph);
        }
    }


    public <R extends Request<S> , S extends Response>
    ThenResponse<S> request(RequestFactory<R, S> requestFactory) {
        // 保持请求
        // T request = requestFactory.create();
        RequestGraph graph = new RequestGraph();
        graph.addRequest(requestFactory);
        return new ThenResponse<S>(graph);
    }

}
