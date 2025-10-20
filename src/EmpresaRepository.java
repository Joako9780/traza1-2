import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaRepository {
    private Map<Integer, Empresa> empresas = new HashMap<>();

    public void addEmpresa(Empresa empresa) {
        if (empresa != null && empresa.getCuit() != null) {
            empresas.put(empresa.getCuit(), empresa);
        }
    }

    public void mostrarTodas() {
        empresas.values().forEach(System.out::println);
    }

    public Empresa buscarPorId(Integer cuit) {
        return empresas.get(cuit);
    }

    public List<Empresa> buscarPorNombre(String nombre) {
        List<Empresa> result = new ArrayList<>();
        for (Empresa e : empresas.values()) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                result.add(e);
            }
        }
        return result;
    }

    public boolean actualizarCuit(Integer oldCuit, Integer newCuit) {
        Empresa empresa = empresas.remove(oldCuit);
        if (empresa != null) {
            empresa.setCuit(newCuit);
            empresas.put(newCuit, empresa);
            return true;
        }
        return false;
    }

    public boolean eliminarPorId(Integer cuit) {
        return empresas.remove(cuit) != null;
    }
}
