package elpu.virtual.api.domain.Suministro;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Suministros")
@Table(name = "suministros")
@Getter
@Setter
@Data
@NoArgsConstructor
public class Suministro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruta;
    private String codigo_suministro;
    private Integer zonafk;
    private Long usuariofk;

    public Suministro(String ruta, String codigo_suministro, String usuariofk){
        this.ruta = ruta;
        this.codigo_suministro = codigo_suministro;
        this.zonafk = Integer.parseInt(ruta.substring(0,3));
        this.usuariofk = 1L;
    }
}