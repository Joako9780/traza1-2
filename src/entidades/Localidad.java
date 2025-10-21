package entidades;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "provincia")
public class Localidad {
    private String nombre;
    private Provincia provincia;

    @Builder.Default
    private Set<Domicilio> domicilios = new HashSet<>();
}
