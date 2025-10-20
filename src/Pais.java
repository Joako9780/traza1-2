import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Pais {
    public String nombre;

    @Builder.Default
    private Set<Provincia> provincias = new HashSet<>();
}
