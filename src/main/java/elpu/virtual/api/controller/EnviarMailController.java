package elpu.virtual.api.controller;

import elpu.virtual.api.domain.correo.Correo;
import elpu.virtual.api.domain.usuario.Usuario;
import elpu.virtual.api.domain.usuario.UsuariosRepository;
import elpu.virtual.api.services.CrearPassNuevo;
import elpu.virtual.api.services.EnviarEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recuperar")
public class EnviarMailController {
    @Autowired
    private EnviarEmailService enviarEmailService;
    @Autowired
    private CrearPassNuevo crearPassNuevo;
    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity recuperarContraseña(
            @RequestBody Correo correo
            //@RequestBody String toEmail, @RequestParam String subject, @RequestParam String body
            ){
        Usuario usuario = usuariosRepository.getUsuariosByCorreo(correo.getToEmail());
        if (usuario!=null){
            String nuevaContra = crearPassNuevo.generateRandomString(6);
            String encryptedPassword = passwordEncoder.encode(nuevaContra);
            usuario.setPassword(encryptedPassword);
            usuariosRepository.save(usuario);
            enviarEmailService.sendEmail(correo.getToEmail(),"Electro Puno: Restablecimiento de Contraseña",
                    "Estimado Cliente.\n\n Se ha restablecido los datos de inicio de sesión de su cuenta " +
                            "con los siguientes datos: \nDNI:" + usuario.getDni() + "\nSu nueva Contraseña es: " + nuevaContra + "\n\n ELECTRO PUNO S.A.A. ");
            return ResponseEntity.ok("Revise su contraseña en su bandeja de Correo Electrónico");
        }
        return ResponseEntity.ok("No existe el correo");
    }
}