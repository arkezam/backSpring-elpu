package elpu.virtual.api.controller;

import elpu.virtual.api.domain.Reportes.Foto;
import elpu.virtual.api.domain.Reportes.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/enviarFoto")
public class ReportarController {
    @Autowired
    FotoRepository fotoRepository;
    @PostMapping
    public String procesarFoto(@RequestParam("imagen") MultipartFile imagen, @RequestParam("dni") String dni) throws IOException {

        if(!imagen.isEmpty()){
            Path directorioImagenes = Paths.get("src//main//resources//static//images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImage = imagen.getBytes();
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
                String formatDateTime = now.format(formatter);
                String tipoContenido = imagen.getContentType();
                tipoContenido = tipoContenido.replaceAll("/", ".");

                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + dni +"-" + formatDateTime + ".png");
                Files.write(rutaCompleta, bytesImage);
                Foto foto = new Foto(imagen.getOriginalFilename(), imagen.getContentType(), dni);
                fotoRepository.save(foto);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return "redirect:/listar";
    }



}
