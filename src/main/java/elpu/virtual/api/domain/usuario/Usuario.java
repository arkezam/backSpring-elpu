package elpu.virtual.api.domain.usuario;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dni;
    private String password;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String cel;
    private String parentezco;
    private String token;

    public Usuario(DatosRegistroUsuario datosRegistroUsuario) {
        this.dni = datosRegistroUsuario.dni();
        this.password = datosRegistroUsuario.password();
        this.nombres = datosRegistroUsuario.nombres();
        this.apellidoPaterno = datosRegistroUsuario.apellidoPaterno();
        this.apellidoMaterno = datosRegistroUsuario.apellidoMaterno();
        this.correo = datosRegistroUsuario.correo();
        this.cel = datosRegistroUsuario.cel();
        this.parentezco = datosRegistroUsuario.parentezco();
        this.token = datosRegistroUsuario.token();
    }

    public Usuario(DatosRespuestaUsuario datosUsuario) {
        this.dni = datosUsuario.dni();
        this.nombres = datosUsuario.nombres();
        this.apellidoPaterno = datosUsuario.apellidoPaterno();
        this.apellidoMaterno = datosUsuario.apellidoMaterno();
        this.correo = datosUsuario.correo();
        this.cel = datosUsuario.cel();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return dni;
    }



    public Long getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void actualizarDatos(DatosActualizarUsuario datosActualizarUsuario) {

        if(datosActualizarUsuario.token() != null){
            this.token = datosActualizarUsuario.token();
        }


    }
}
