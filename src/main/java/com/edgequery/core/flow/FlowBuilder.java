package com.edgequery.core.flow;

import com.edgequery.core.RequestFactory;
import com.edgequery.core.RequestFactoryNonParam;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;

/**
 * Created by caoyangmin on 2018/3/31.
 */
public class FlowBuilder {

    private DirectedAcyclicGraph<Node, DefaultEdge> dag;
    final private Begin begin;

    public class Begin implements Node{

        public RequestTask connect(RequestFactory to){
            return FlowBuilder.this.connect(begin, to);
        }
    }

    public FlowBuilder(){
        begin = new Begin();
        dag = new DirectedAcyclicGraph<Node, DefaultEdge>(DefaultEdge.class);
        dag.addVertex(begin);
    }

    public RequestTask connect(Node from, RequestFactory to){
        RequestTask task = new RequestTask().setRequestFactory(to);
        dag.addVertex(task);
        dag.addEdge(from,task);
        return task;
    }

    public Begin begin(){
        return begin;
    }

    public DirectedAcyclicGraph<Node, DefaultEdge> build(){
        return dag;
    }
}
