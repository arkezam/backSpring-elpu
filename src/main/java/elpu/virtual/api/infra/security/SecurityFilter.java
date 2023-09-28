package elpu.virtual.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import elpu.virtual.api.domain.usuario.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//el componenet es generico
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private UsuariosRepository usuariosRepository;
    @Autowired
    private TokenService tokenService;
    //Este filtro se ejecuta antes de todos los request
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("el filtro esta llamado");
        if(request.getRequestURI().equals("/")) {
            System.out.println("dentro");
            filterChain.doFilter(request, response);
            return;
        }
        //se debe obtener el token para verificar
        var authHeader = request.getHeader("Authorization");

        if ( authHeader != null){
            var token= authHeader.replace("Bearer ","");
            var dni = tokenService.getSubject(token);

            System.out.println(token);
            System.out.println(dni);
            if(dni != null){//si llega nombre de usuario significa que es valido
                var usuario =  usuariosRepository.findByDni(dni);
                var authentication = new UsernamePasswordAuthenticationToken(usuario,null, usuario.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }

        filterChain.doFilter(request,response);
    }
}
