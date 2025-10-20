import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    private Long id;
    private String denominacion;
}