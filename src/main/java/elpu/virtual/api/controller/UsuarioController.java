package elpu.virtual.api.controller;

import elpu.virtual.api.domain.usuario.DatosRegistroUsuario;
import elpu.virtual.api.domain.usuario.Usuario;
import elpu.virtual.api.domain.usuario.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registro")
public class UsuarioController {

    @Autowired
    UsuariosRepository usuariosRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping
    public ResponseEntity registrarUsuario(@RequestBody DatosRegistroUsuario datosRegistroUsuario) {
        String encryptedPassword = passwordEncoder.encode(datosRegistroUsuario.password());
        Usuario usuario = new Usuario(new DatosRegistroUsuario(datosRegistroUsuario.dni(),
                encryptedPassword,
                datosRegistroUsuario.nombres(),
                datosRegistroUsuario.apellidoPaterno(),
                datosRegistroUsuario.apellidoMaterno(),
                datosRegistroUsuario.correo(),
                datosRegistroUsuario.cel(),
                datosRegistroUsuario.parentezco(),
                datosRegistroUsuario.token()));
        usuariosRepository.save(usuario);
        return ResponseEntity.ok().body("Registro Exitoso");
    }


}
