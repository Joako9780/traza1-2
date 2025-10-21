import entidades.*;
import repositorios.InMemoryRepository;

import javax.swing.text.html.Option;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        /* ========================
                  TRAZA 1
        ======================== */

        InMemoryRepository<Empresa> empresaRepository = new InMemoryRepository<>();

        System.out.println(" ===== COMIENZA EJECUCION ===== ");

        Pais argentina = Pais.builder()
                .nombre("Argentina")
                .build();

        Provincia p1 = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(argentina)
                .build();

        Provincia p2 = Provincia.builder()
                .nombre("Cordoba")
                .pais(argentina)
                .build();

        Localidad l1 = Localidad.builder()
                .nombre("CABA")
                .provincia(p1)
                .build();

        Localidad l2 = Localidad.builder()
                .nombre("La plata")
                .provincia(p1)
                .build();

        Localidad l3 = Localidad.builder()
                .nombre("Cordoba Capital")
                .provincia(p2)
                .build();

        Localidad l4 = Localidad.builder()
                .nombre("Villa Carlos Paz")
                .provincia(p2)
                .build();

        Domicilio d1 = Domicilio.builder()
                .calle("Florencio Varela")
                .numero(376)
                .cp(4410)
                .localidad(l1)
                .build();

        Domicilio d2 = Domicilio.builder()
                .localidad(l2)
                .calle("Calle 7")
                .numero(1100)
                .cp(1900)
                .build();

        Domicilio d3 = Domicilio.builder()
                .localidad(l3)
                .calle("25 de Mayo")
                .numero(123)
                .cp(5000)
                .build();

        Domicilio d4 = Domicilio.builder()
                .localidad(l4)
                .calle("Avenida San Martin")
                .numero(500)
                .cp(5152)
                .build();

        Sucursal s1 = Sucursal.builder()
                .nombre("Limpito")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(20, 0))
                .domicilio(d1)
                .build();

        Sucursal s2 = Sucursal.builder()
                .nombre("Limpito Emporio de la Limpieza")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(19, 0))
                .domicilio(d2)
                .build();

        Sucursal s3 = Sucursal.builder()
                .nombre("Limpito Productos de Limpieza")
                .horarioApertura(LocalTime.of(9, 0))
                .horarioCierre(LocalTime.of(19, 0))
                .domicilio(d3)
                .build();

        Sucursal s4 = Sucursal.builder()
                .nombre("Limpito!")
                .horarioApertura(LocalTime.of(8, 0))
                .horarioCierre(LocalTime.of(20, 0))
                .domicilio(d4)
                .build();

        Empresa e1 = Empresa.builder()
                .nombre("Limpito Emporio de la Limpieza Buenos Aires")
                .razonSocial("Limpito S.A")
                .cuit(592380071L)
                .logo("Cuidamos tu hogar")
                .build();

        Empresa e2 = Empresa.builder()
                .nombre("Limpito Emporio de la Limpieza Cordoba")
                .razonSocial("Limpito S.A")
                .cuit(592380071L)
                .logo("Animate a limpiar ahorrando")
                .build();

        e1.agregarSucursal(s1);
        e1.agregarSucursal(s2);

        e2.agregarSucursal(s3);
        e2.agregarSucursal(s4);

        /* ========================
                  TRAZA 2
        ======================== */

        // Ejercicio 4

        InMemoryRepository<Categoria> categoriaRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloInsumo> articuloInsumoRepository = new InMemoryRepository<>();
        InMemoryRepository<ArticuloManufacturado> articuloManufacturadoRepository = new InMemoryRepository<>();
        InMemoryRepository<UnidadMedida> unidadMedidaRepository = new InMemoryRepository<>();

        Categoria catPizzas = Categoria.builder().denominacion("Pizzas").build();
        Categoria catSandwitch = Categoria.builder().denominacion("Sándwitch").build();
        Categoria catLomos = Categoria.builder().denominacion("Lomos").build();
        Categoria catInsumos = Categoria.builder().denominacion("Insumos").build();

        categoriaRepository.save(catPizzas);
        categoriaRepository.save(catSandwitch);
        categoriaRepository.save(catLomos);
        categoriaRepository.save(catInsumos);

        UnidadMedida kg = UnidadMedida.builder().denominacion("Kilogramos").build();
        UnidadMedida litro = UnidadMedida.builder().denominacion("Litros").build();
        UnidadMedida gramo = UnidadMedida.builder().denominacion("Gramos").build();

        unidadMedidaRepository.save(kg);
        unidadMedidaRepository.save(litro);
        unidadMedidaRepository.save(gramo);

        ArticuloInsumo sal = ArticuloInsumo.builder().denominacion("Sal").precioVenta(10.0).precioCompra(5.0).stockActual(100).stockMaximo(500).esParaElaborar(true).build();
        ArticuloInsumo aceite = ArticuloInsumo.builder().denominacion("Aceite").precioVenta(50.0).precioCompra(30.0).stockActual(200).stockMaximo(400).esParaElaborar(true).build();
        ArticuloInsumo carne = ArticuloInsumo.builder().denominacion("Carne").precioVenta(200.0).precioCompra(150.0).stockActual(50).stockMaximo(200).esParaElaborar(true).build();
        ArticuloInsumo harina = ArticuloInsumo.builder().denominacion("Harina").precioVenta(80.0).precioCompra(40.0).stockActual(300).stockMaximo(600).esParaElaborar(true).build();

        articuloInsumoRepository.save(sal);
        articuloInsumoRepository.save(aceite);
        articuloInsumoRepository.save(carne);
        articuloInsumoRepository.save(harina);

        Imagen img1 = Imagen.builder().denominacion("HawainaPizza1").build();
        Imagen img2 = Imagen.builder().denominacion("HawainaPizza2").build();
        Imagen img3 = Imagen.builder().denominacion("HawainaPizza3").build();
        Imagen img4 = Imagen.builder().denominacion("LomoCompleto1").build();
        Imagen img5 = Imagen.builder().denominacion("LomoCompleto2").build();
        Imagen img6 = Imagen.builder().denominacion("LomoCompleto3").build();

        ArticuloManufacturadoDetalle detallePizza1 = ArticuloManufacturadoDetalle.builder().cantidad(1).insumo(sal).build();
        ArticuloManufacturadoDetalle detallePizza2 = ArticuloManufacturadoDetalle.builder().cantidad(2).insumo(harina).build();
        ArticuloManufacturadoDetalle detallePizza3 = ArticuloManufacturadoDetalle.builder().cantidad(1).insumo(aceite).build();

        ArticuloManufacturadoDetalle detalleLomo1 = ArticuloManufacturadoDetalle.builder().cantidad(1).insumo(sal).build();
        ArticuloManufacturadoDetalle detalleLomo2 = ArticuloManufacturadoDetalle.builder().cantidad(1).insumo(aceite).build();
        ArticuloManufacturadoDetalle detalleLomo3 = ArticuloManufacturadoDetalle.builder().cantidad(1).insumo(carne).build();

        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaiana")
                .precioVenta(1200.0)
                .descripcion("Pizza con ananá y jamón")
                .tiempoEstimadoMinutos(20)
                .preparacion("Horno de leña")
                .categoria(catPizzas)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .detalles(new HashSet<>(Set.of(detallePizza1, detallePizza2, detallePizza3)))
                .build();

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .denominacion("Lomo Completo")
                .precioVenta(1500.0)
                .descripcion("Lomo completo con papas fritas")
                .tiempoEstimadoMinutos(25)
                .preparacion("Plancha")
                .categoria(catLomos)
                .imagenes(new HashSet<>(Set.of(img4, img5, img6)))
                .detalles(new HashSet<>(Set.of(detalleLomo1, detalleLomo2, detalleLomo3)))
                .build();

        articuloManufacturadoRepository.save(pizzaHawaina);
        articuloManufacturadoRepository.save(lomoCompleto);

        // Ejercicio 5

        // a)

        System.out.println("\n//// CATEGORÍAS ////");
        List<Categoria> listaCategorias = categoriaRepository.findAll();
        listaCategorias.forEach(System.out::println);

        // b)

        System.out.println("\n//// INSUMOS ////");
        List<ArticuloInsumo> listaArticulosInsumos = articuloInsumoRepository.findAll();
        // El profesor nos solicitó mostrar solamente la denominación de los artículos con este for
        for (ArticuloInsumo ai : listaArticulosInsumos) {
            System.out.println(ai.getDenominacion());
        }

        // c)

        System.out.println("\n//// MANUFACTURADOS ////");
        List<ArticuloManufacturado> listaArticulosManufacturados = articuloManufacturadoRepository.findAll();
        listaArticulosManufacturados.forEach(System.out::println);

        // d)

        System.out.println("\n//// BUSCAR MANUFACTURADO ID=2 ////");
        Optional<ArticuloManufacturado> articuloBuscado = articuloManufacturadoRepository.findById(2L);
        articuloBuscado.ifPresent(a -> System.out.println("Artículo manufacturado encontrado con ID 2: " + a));

        // e)

        System.out.println("\n//// ACTUALIZAR MANUFACTURADO ID=1 ////");
        ArticuloManufacturado pizzaHawaianaActualizada = ArticuloManufacturado.builder()
                .denominacion("Pizza Hawaiana Actualizada")
                .precioVenta(1400.0)
                .descripcion("Pizza con ananá y jamón")
                .tiempoEstimadoMinutos(18)
                .preparacion("Horno de leña")
                .categoria(catPizzas)
                .imagenes(new HashSet<>(Set.of(img1, img2, img3)))
                .detalles(new HashSet<>(Set.of(detallePizza1, detallePizza2, detallePizza3)))
                .build();

        articuloManufacturadoRepository.genericUpdate(1L, pizzaHawaianaActualizada);
        Optional<ArticuloManufacturado> articuloActualizado = articuloManufacturadoRepository.findById(1L);
        articuloActualizado.ifPresent(a -> System.out.println("Articulo Manufacturado con ID 1 ha sido ACTUALIZADO: " + a));

        // f)

        System.out.println("\n//// ELIMINAR MANUFACTURADO CON ID=2////");
        articuloManufacturadoRepository.genericDelete(2L);
        Optional<ArticuloManufacturado> articuloEliminado = articuloManufacturadoRepository.findById(2L);
        if (articuloEliminado.isEmpty()) {
            System.out.println("El articulo con ID 2 ha sido eliminado con EXITO.");
        }

        System.out.println("\n//// TODOS LOS ARTÍCULOS DE SUCURSAL 1 ////");
        listaArticulosManufacturados = articuloManufacturadoRepository.findAll();
        listaArticulosManufacturados.forEach(System.out::println);
    }
}
