import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Domicilio {
    public String calle;
    public Integer numero;
    public Integer cp;

    private Localidad localidad;
}
