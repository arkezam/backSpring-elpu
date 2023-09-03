package elpu.virtual.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import elpu.virtual.api.domain.direccion.Direccion;

public record DatosActualizarMedico(@NotNull Long id, String nombre, String documento, Direccion direccion) {
}
