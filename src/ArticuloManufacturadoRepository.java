import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloManufacturadoRepository {
    private Map<Long, ArticuloManufacturado> articulos = new HashMap<>();

    public void addArticulo(ArticuloManufacturado articulo) {
        if (articulo != null && articulo.getId() != null) {
            articulos.put(articulo.getId(), articulo);
        }
    }

    public void mostrarTodos() {
        articulos.values().forEach(System.out::println);
    }

    public ArticuloManufacturado buscarPorId(Long id) {
        return articulos.get(id);
    }

    public boolean actualizar( Long id, String nuevaDescripcion) {
        ArticuloManufacturado art = articulos.get(id);
        if (art != null) {
            art.setDescripcion(nuevaDescripcion);
            return true;
        }
        return false;
    }

    public boolean eliminarPorId(Long id) {
        return articulos.remove(id) != null;
    }
}
