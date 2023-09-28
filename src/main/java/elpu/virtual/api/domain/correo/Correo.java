package elpu.virtual.api.domain.correo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@AllArgsConstructor
public class Correo implements Serializable {
    private String toEmail;
    private String subject;
    private String body;

}