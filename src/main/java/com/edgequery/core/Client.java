package com.edgequery.core;

public interface Client<T extends Request> {
    T request();
}
