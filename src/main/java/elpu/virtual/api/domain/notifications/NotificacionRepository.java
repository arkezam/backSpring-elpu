package elpu.virtual.api.domain.notifications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface NotificacionRepository extends JpaRepository <Notificacion, Integer> {
    Page<Notificacion> findAllByUsuariofk(Integer usuariofk, Pageable pageable);

}
