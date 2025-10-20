import lombok.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Sucursal {
    @EqualsAndHashCode.Include
    private String nombre;
    private LocalTime horarioApertura;
    private LocalTime horarioCIerre;
    private boolean esCasaMatriz;

    @EqualsAndHashCode.Include
    private Domicilio domicilio;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Empresa empresa;

    @Builder.Default
    private Set<Articulo> articulos = new HashSet<>();

    public void addArticulo(Articulo articulo) {
        if (articulo != null) {
            articulos.add(articulo);
        }
    }
}
