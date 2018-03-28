import com.edgequery.core.EdgeQueryClient;
import com.edgequery.io.http.HttpClient;
import com.edgequery.io.http.HttpRequest;

public class Demo {

    public static void main(String[] args) {

        EdgeQueryClient client = new EdgeQueryClient();

        client.request(()->{
            HttpClient http = new HttpClient();
            return http.request()
                    .url("http://127.0.0.1")
                    .method("GET");

        }).then((response)->{
            return 123;

        }).thenRequest((Integer a)->{
            return new HttpRequest();
        });

    }
}
