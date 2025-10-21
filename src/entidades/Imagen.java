package entidades;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Imagen {
    private Long id;
    private String denominacion;
}
