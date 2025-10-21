package entidades;

import lombok.*;
import lombok.Builder.Default;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "sucursales")
@EqualsAndHashCode(of = "id")
public class Empresa {
    private Long id;
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;

    @Default
    @Setter(AccessLevel.NONE)       //no generar setter público para la lista -> mejor encapsulación
    private Set<Sucursal> sucursales = new HashSet<>();

    // reversion de agregarSucursal en traza1
    public void addSucursal(Sucursal sucursal){
        if(sucursal ==null) return;
        sucursal.setEmpresa(this);      // mantiene consistencia
        this.sucursales.add(sucursal);      // evita duplicados automáticamente
    }

    public boolean removeSucursal(Sucursal sucursal){
        if (sucursal == null) return false;
        boolean removed = this.sucursales.remove(sucursal);
        if (removed) {
            sucursal.setEmpresa(null);
        }
        return removed;
    }
}
