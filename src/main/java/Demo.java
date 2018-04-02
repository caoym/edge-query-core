import com.edgequery.core.EdgeQueryClient;
import com.edgequery.io.http.HttpClient;
import com.edgequery.io.http.HttpRequest;

import java.io.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


public class Demo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        EdgeQueryClient client = new EdgeQueryClient(null);

        CompletableFuture.supplyAsync(()->1).runAfterBoth()
        client.parallelRequest(
                (cl)->{
                    return
                }
        ).then(
                User, Password, Com,
        )


        Integer a = client.request((env) -> {

            HttpClient http = env.getBean(HttpClient.class);

            return http.request()
                    .url("http://127.0.0.1")
                    .method("GET");

        }).then((env, response) -> {

            return 123;
        }).thenRequest((env, p) -> {
            return new HttpRequest();

        }).then((env, res) -> {
            return 456;
        }).execute();



    }
}
