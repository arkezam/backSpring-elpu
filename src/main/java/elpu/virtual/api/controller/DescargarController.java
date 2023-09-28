package elpu.virtual.api.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/descargar")
public class DescargarController {

    @GetMapping
    public ResponseEntity<byte[]> descargarArchivo() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/versions/AppV_1.0.1.apk");
        byte[] fileData = Files.readAllBytes(resource.getFile().toPath());
        String fileName = resource.getFilename(); // Nombre del archivo APK que se descargará

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM) // ContentType para APK
                .header("Content-Disposition", "attachment; filename=" + fileName)
                .body(fileData);
    }
}
