package elpu.virtual.api.controller;

import elpu.virtual.api.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import elpu.virtual.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
@RestController
    @RequestMapping("/api/login")
    public class LoginController {
        @Autowired
        UsuariosRepository usuariosRepository;
        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        private TokenService tokenService;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosLogin datosAutenticacionUsuario) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.dni(),
                datosAutenticacionUsuario.password());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        String JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        Usuario usuario = usuariosRepository.getUsuariosByDni(datosAutenticacionUsuario.dni());
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getDni(), usuario.getNombres(), usuario.getApellidoPaterno(), usuario.getApellidoMaterno(), usuario.getCorreo(), usuario.getCel(),JWTtoken);
        System.out.printf(JWTtoken);
        return ResponseEntity.ok(datosRespuestaUsuario);
    }
    @PutMapping
    @Transactional
    public ResponseEntity actualizarToken( @RequestBody DatosActualizarUsuario datosActualizarUsuario ){
        Usuario usuario = usuariosRepository.getUsuariosByDni(datosActualizarUsuario.dni());
        usuario.actualizarDatos(datosActualizarUsuario);
        return ResponseEntity.ok(datosActualizarUsuario.token());
    }

}