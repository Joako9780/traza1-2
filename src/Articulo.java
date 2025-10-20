import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Data

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"imagenes"})
@SuperBuilder
public abstract class Articulo {
    private Long id;
    private String denominacion;
    private Double precioVenta;

    @Builder.Default
    private Set<Imagen> imagenes = new HashSet<>();

    public void addImagen(Imagen img) {
        if (img != null) {
            this.imagenes.add(img);
        }
    }
}
