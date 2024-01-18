package elpu.virtual.api.domain.Suministro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuministroRepository extends JpaRepository <Suministro, Long >{
}
