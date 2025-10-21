package entidades;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "localidad")
public class Domicilio {
    private Long id;
    private String calle;
    private Integer numero;
    private Integer cp;

    private Localidad localidad;
}
