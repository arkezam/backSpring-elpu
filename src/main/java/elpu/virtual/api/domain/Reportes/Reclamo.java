package elpu.virtual.api.domain.Reportes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class Reclamo implements Serializable {
        private String suministro;
        private String nombres;
        private String apellidos;
        private String dni;
        private String telefono;
        private String correo;
        private String sede;
        private String tipo;
        private String reclamo;


}