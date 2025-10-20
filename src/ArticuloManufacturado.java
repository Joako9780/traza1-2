import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = {"detalles"})
@SuperBuilder
public class ArticuloManufacturado extends Articulo {
    private String descripcion;
    private Integer tiempoEstimadoMinutos;
    private String preparacion;

    private Categoria categoria;

    @Builder.Default
    private Set<ArticuloManufacturadoDetalle> detalles = new HashSet<>();

    public void addDetalle(ArticuloManufacturadoDetalle detalle) {
        if (detalle != null) {
            this.detalles.add(detalle);
        }
    }
}
