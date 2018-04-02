package com.edgequery.core.flow;

import com.edgequery.core.utils.AssertEx;
import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;
import java.util.*;

/**
 * Created by caoyangmin on 2018/3/31.
 */
@NotThreadSafe
public class Flow{

    static class NodeNotExist extends RuntimeException{
        NodeNotExist(String message){super(message);}
    }
    private HashMap<Object, List<Object>> graph = new HashMap<>();

    public void addNode(@Nonnull Object node){
        Preconditions.checkNotNull(node);
        if(!hasNoe(node)){
            graph.put(node, new LinkedList<>());
        }
    }


    public boolean hasNoe(@Nonnull Object node){
        Preconditions.checkNotNull(node);
        return graph.containsKey(node);
    }

    public void linkTo(Object from, Object to) throws NodeNotExist{

        Preconditions.checkNotNull(from);
        Preconditions.checkNotNull(to);

        List<Object> dests;
        AssertEx.isTrue((dests = graph.get(from)) != null, "the 'from' node not exist", NodeNotExist.class);
        AssertEx.isTrue(graph.containsKey(to), "the 'to' node not exist", NodeNotExist.class);

        if(dests.contains(to)) return;

        dests.add(to);

    }


}
