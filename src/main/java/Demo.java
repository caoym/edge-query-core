import com.edgequery.core.EdgeQueryClient;
import com.edgequery.core.Env;
import com.edgequery.core.ParallelQueryScope;
import com.edgequery.core.RequestFuture;
import com.edgequery.io.http.HttpClient;
import com.edgequery.io.http.HttpRequest;

import java.io.*;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        EdgeQueryClient client = new EdgeQueryClient(null);

        RequestFuture<Object> test = null;

        // 1. 请求登录
        test.request((env, v) -> {

            HttpClient http = env.getBean(HttpClient.class);

            return http.request()
                    .url("http://127.0.0.1")
                    .method("GET");

        })
        .then((evn,res)->{
            return 23;
        })
        // 2. 同时请求用户数据和订单数据
        .parallelRequests((req, v)->{

            req.request((env,v1)->{
                HttpClient http = env.getBean(HttpClient.class);
                return http.request()
                        .url("http://127.0.0.1")
                        .method("GET");
            }).then((vv,vvv)->{
                return 333;
            });

        }).request((env)->{

            return null;
        });

    }
}
