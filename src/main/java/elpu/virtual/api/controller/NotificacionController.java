
package elpu.virtual.api.controller;
import elpu.virtual.api.domain.notifications.DatosNotificacion;
import elpu.virtual.api.domain.notifications.Notificacion;
import elpu.virtual.api.domain.notifications.NotificacionRepository;
import elpu.virtual.api.domain.usuario.Usuario;
import elpu.virtual.api.domain.usuario.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/notificacion")
public class NotificacionController {

    @Autowired
    NotificacionRepository notificacionRepository;
    @Autowired
    UsuariosRepository usuariosRepository;

    @PostMapping
    public  Page<Notificacion> obtenerNotificaciones(@RequestBody DatosNotificacion datos, Pageable paginacion){

        Usuario cliente = usuariosRepository.getUsuariosByDni(datos.dni());
        var id = cliente.getId();
        System.out.println(cliente.getId());
        return notificacionRepository.findAllByUsuariofk(id.intValue(), paginacion);
    }

}
