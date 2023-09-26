package elpu.virtual.api.domain.usuario;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    UserDetails findByDni(String dni);
    Usuario getUsuariosByDni(String dni);
    Usuario getUsuariosByCorreo(String email);

}
