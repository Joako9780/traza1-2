import lombok.*;
import lombok.Builder.Default;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "sucursales")


public class Empresa {
    private String nombre;
    private String razonSocial;
    private Integer cuit;
    private String logo;

    @Default
    @Setter(AccessLevel.NONE)       //no generar setter público para la lista -> mejor encapsulación
    private Set<Sucursal> sucursales = new HashSet<>();
    // metodos para manejar la colección (encapsulan la lista)
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
