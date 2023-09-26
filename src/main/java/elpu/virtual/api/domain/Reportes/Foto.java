package elpu.virtual.api.domain.Reportes;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
public class Foto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nombre;
    String mimetype;
    @Lob
    String dnifk;

    public Foto() {
    }

    public Foto(String nombre, String mimeType, String fotoBase64){
        this.nombre = nombre;
        this.mimetype = mimeType;
        this.dnifk = fotoBase64;
    }
}