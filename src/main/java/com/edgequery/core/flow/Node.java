package com.edgequery.core.flow;

public interface Node {
    default boolean canConnectTo(Node to){
        return false;
    }
    default boolean canConnectFrom(Node from)
    {
        return false;
    }
    default void run(){

    }
}
