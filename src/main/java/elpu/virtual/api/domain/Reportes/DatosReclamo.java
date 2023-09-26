package elpu.virtual.api.domain.Reportes;

import org.springframework.data.jpa.repository.JpaRepository;

public record DatosReclamo (String suministro, String nombres, String apellido, String dni, String celular, String correo, String tipo, String comentario) {
}
