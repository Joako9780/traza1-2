import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticuloManufacturadoDetalle {
    private Long id;
    private Integer cantidad;

    private ArticuloInsumo insumo;
}
