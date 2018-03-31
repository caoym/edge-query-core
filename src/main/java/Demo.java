import com.edgequery.core.EdgeQueryClient;
import com.edgequery.core.RequestFactory;
import com.edgequery.io.http.HttpClient;
import com.edgequery.io.http.HttpRequest;
import com.esotericsoftware.kryo.Kryo;

import java.io.*;
import java.lang.invoke.CallSite;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.function.Function;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.io.Input;


public class Demo {


    interface Test extends Serializable{
        void run();
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {

        EdgeQueryClient client = new EdgeQueryClient(null);

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
