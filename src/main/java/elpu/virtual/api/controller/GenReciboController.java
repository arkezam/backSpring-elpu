package elpu.virtual.api.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/api/genrecibo")
public class GenReciboController {

    @PostMapping
    public ResponseEntity<byte[]> consultar(@RequestBody String codigo) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://web.electropuno.com.pe/OficinaVirtualV2/verReciboExt.aspx"))
                .POST(HttpRequest.BodyPublishers.ofString(codigo))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();

        HttpResponse<byte[]> response = httpClient.send(request, HttpResponse.BodyHandlers.ofByteArray());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(response.body(), headers, HttpStatus.OK);
    }


}
