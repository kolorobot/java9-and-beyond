package pl.codeleak.samples.java9;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

/* New Http Client was introduced in Java 9 (incubation), but in Java 11 it was revised. These examples are based on Java 11 */
class Java9HttpClientTests {

    @Test
    void httpGet() throws IOException, InterruptedException {

        // build a request
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://google.com"))
                .build();

        HttpResponse<String> httpResponse = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_2) // defaults to HTTP/2
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());

        assertThat(httpResponse.version()).isEqualTo(HttpClient.Version.HTTP_2);
        assertThat(httpResponse.statusCode()).isEqualTo(200);
    }

    @Test
    void httpPostWithBodyAcceptingJson() throws IOException, InterruptedException {

        // build a request
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString("{\"demo\": \"true\"}"))
                .uri(URI.create("https://httpbin.org/post"))
                .header("accept", "application/json")
                .build();

        HttpClient httpClient = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        assertThat(httpResponse.version()).isEqualTo(HttpClient.Version.HTTP_1_1);
        assertThat(httpResponse.statusCode()).isEqualTo(200);
    }

    @Test
    void downloadsFile() throws IOException, InterruptedException {

        // build a request
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/image"))
                .header("accept", "image/png")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<Path> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofFile(Path.of("target/my-file.png")));

        assertThat(httpResponse.statusCode()).isEqualTo(200);
        assertThat(httpResponse.body())
                .isRegularFile()
                .hasFileName("my-file.png");
    }
}
