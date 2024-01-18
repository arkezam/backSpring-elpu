package elpu.virtual.api.domain.notifications;


import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Table(name = "notificaciones")
@Entity(name = "notificacion")

public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String titulo;
    public String mensaje;


    public Integer usuariofk;

    public String fecha_notificacion;


    public Notificacion() {

    }
    public Notificacion(String mensaje, String fecha) {
        this.mensaje = mensaje;
        this.fecha_notificacion = fecha;
    }
//    public String getDniUsuario() {
//        return usuario != null ? usuario.getDni() : null;
//    }
}
