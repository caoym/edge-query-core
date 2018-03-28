package com.edgequery.io.http;

import com.edgequery.core.Client;

public class HttpClient implements Client {

    @Override
    public HttpRequest request() {
        return new HttpRequest();
    }
}
