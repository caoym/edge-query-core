package com.edgequery.core.flow;

import com.edgequery.core.RequestFactory;
import com.edgequery.core.ResponseHandler;

import javax.annotation.Nonnull;

public class RequestTask extends Node{
    private RequestFactory requestFactory;
    private ResponseHandler responseHandler;

    public RequestTask setRequestFactory(@Nonnull RequestFactory requestFactory) {
        this.requestFactory = requestFactory;
        return this;
    }

    public RequestTask setResponseHandler(@Nonnull ResponseHandler responseHandler) {
        this.responseHandler = responseHandler;
        return this;
    }

    public RequestFactory getRequestFactory() {
        return requestFactory;
    }

    public ResponseHandler getResponseHandler() {
        return responseHandler;
    }
}
