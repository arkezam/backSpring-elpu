package elpu.virtual.api.domain.Reportes;

import elpu.virtual.api.domain.Reportes.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {


}