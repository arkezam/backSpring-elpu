package elpu.virtual.api.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import elpu.virtual.api.domain.Reportes.DatosReclamo;
import elpu.virtual.api.domain.Reportes.Reclamo;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
@RestController
@RequestMapping("/api/reclamo")
public class ReclamoController {

    @PostMapping
    public ResponseEntity<String> enviarReclamo(@RequestBody Reclamo form) throws IOException, InterruptedException {
        RestTemplate rest = new RestTemplate();

        // Configura los datos como form values
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("suministro", form.getSuministro()); // Reemplaza "campo1" con el nombre real del campo
        map.add("nombres", form.getNombres()); // Reemplaza "campo2" con el nombre real del campo
        map.add("apellidos", form.getApellidos());
        map.add("dni", form.getDni());
        map.add("telefono", form.getTelefono());
        map.add("correo", form.getCorreo());
        map.add("sede", form.getSede());
        map.add("tipo", form.getTipo());
        map.add("reclamo", form.getReclamo());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String url = "http://std.electropuno.com.pe/stdandroid/in/web/reclamos/rDatos";

        ResponseEntity<String> response = rest.postForEntity(url, request, String.class);

        return ResponseEntity.ok(form.toString());
    }

}
