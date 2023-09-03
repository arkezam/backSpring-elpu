package elpu.virtual.api.domain.medico;

import elpu.virtual.api.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id, String nombre, String especialidad, String telefono, String documento,
                                   DatosDireccion direccion) {
}
