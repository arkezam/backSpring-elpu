package elpu.virtual.api.infra.security;

import elpu.virtual.api.domain.usuario.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionService implements UserDetailsService {

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override

    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        return usuariosRepository.findByDni(dni);
    }
}
