package com.edgequery.io.http;

import com.edgequery.core.Request;
import com.edgequery.core.ResponseHandler;

public class HttpRequest implements Request<HttpResponse> {

    public HttpRequest method(String method){
        return this;
    }
    public HttpRequest url(String url){
        return this;
    }

    @Override
    public <T> Request<HttpResponse> then(ResponseHandler<HttpResponse, T> responseHandler) {
        return null;
    }
}
