package elpu.virtual.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import elpu.virtual.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(@NotBlank
                                  String nombre,
                                  @NotBlank
                                  @Email
                                  String email,
                                  @NotBlank
                                  @Pattern(regexp = "\\d{4,6}")
                                  String documento,
                                  @NotNull
                                  Especialidad especialidad,
                                  String ativo,
                                  @NotBlank
                                  String telefono,
                                  @NotNull
                                  @Valid
                                  DatosDireccion direccion)
{}
