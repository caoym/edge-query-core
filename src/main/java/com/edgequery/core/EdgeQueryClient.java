package com.edgequery.core;


public class EdgeQueryClient {

    public class ThenRequest<T>{

        public <R extends Request<S> ,S extends Response> ThenResponse<S> thenRequest(
                RequestFactoryWithParam<R, S, T> requestFactory) {

            return new ThenResponse<S>();
        }
    }

    public class ThenResponse<S extends Response>{

        public <T> ThenRequest<T> then(ResponseHandler<S, T> responseHandler){
            return new ThenRequest<T>();
        }
    }


    public <R extends Request<S> ,S extends Response, V> ThenResponse<S> request(
            RequestFactory<R, S> requestFactory) {

        //保持请求
        // T request = requestFactory.create();

        return new ThenResponse<S>();
    }

    private void dispatch(){

    }


}
