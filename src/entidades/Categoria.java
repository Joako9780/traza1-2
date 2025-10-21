package entidades;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private Long id;
    private String denominacion;
}