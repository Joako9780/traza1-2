import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {

        /* ========================
                EJERCICIO 1
        ======================== */

        Pais argentina = Pais.builder().nombre("Argentina").build();

        Provincia buenosAires = Provincia.builder().nombre("Buenos Aires").pais(argentina).build();
        Provincia cordoba = Provincia.builder().nombre("Córdoba").pais(argentina).build();

        Localidad caba = Localidad.builder().nombre("CABA").provincia(buenosAires).build();
        Localidad laPlata = Localidad.builder().nombre("La Plata").provincia(buenosAires).build();
        Localidad cordobaCapital = Localidad.builder().nombre("Córdoba Capital").provincia(cordoba).build();
        Localidad villaCarlosPaz = Localidad.builder().nombre("Villa Carlos Paz").provincia(cordoba).build();

        Domicilio domCaba = Domicilio.builder().calle("Av. Corrientes").numero(123).cp(1000).localidad(caba).build();
        Domicilio domLaPlata = Domicilio.builder().calle("Calle 50").numero(124).cp(1900).localidad(laPlata).build();
        Domicilio domCordoba = Domicilio.builder().calle("Colón").numero(500).cp(5000).localidad(cordobaCapital).build();
        Domicilio domCarlosPaz = Domicilio.builder().calle("Av. Libertad").numero(250).cp(5152).localidad(villaCarlosPaz).build();

        Sucursal sucursal1 = Sucursal.builder().nombre("Sucursal 1").domicilio(domCaba).horarioApertura(LocalTime.of(9,0)).horarioCIerre(LocalTime.of(20,0)).build();
        Sucursal sucursal2 = Sucursal.builder().nombre("Sucursal 2").domicilio(domLaPlata).horarioApertura(LocalTime.of(9,0)).horarioCIerre(LocalTime.of(20,0)).build();
        Sucursal sucursal3 = Sucursal.builder().nombre("Sucursal 3").domicilio(domCordoba).horarioApertura(LocalTime.of(10,0)).horarioCIerre(LocalTime.of(22,0)).build();
        Sucursal sucursal4 = Sucursal.builder().nombre("Sucursal 4").domicilio(domCarlosPaz).horarioApertura(LocalTime.of(10,0)).horarioCIerre(LocalTime.of(22,0)).build();

        Empresa empresa1 = Empresa.builder().nombre("Empresa 1").razonSocial("Empresa Uno S.A.").cuit(12345678).logo("logo1.png").build();
        empresa1.addSucursal(sucursal1);
        empresa1.addSucursal(sucursal2);

        Empresa empresa2 = Empresa.builder().nombre("Empresa 2").razonSocial("Empresa Dos S.A.").cuit(87654321).logo("logo2.png").build();
        empresa2.addSucursal(sucursal3);
        empresa2.addSucursal(sucursal4);

        EmpresaRepository repoEmpresas = new EmpresaRepository();
        repoEmpresas.addEmpresa(empresa1);
        repoEmpresas.addEmpresa(empresa2);

        System.out.println("\n//// EMPRESAS ////");
        repoEmpresas.mostrarTodas();

        /* ========================
                EJERCICIO 2
        ======================== */

        Categoria catPizzas = Categoria.builder().id(1L).denominacion("Pizzas").build();
        Categoria catLomos = Categoria.builder().id(2L).denominacion("Lomos").build();
        Categoria catInsumos = Categoria.builder().id(3L).denominacion("Insumos").build();

        UnidadMedida kg = UnidadMedida.builder().id(1L).denominacion("Kilogramos").build();
        UnidadMedida litro = UnidadMedida.builder().id(2L).denominacion("Litros").build();
        UnidadMedida gramo = UnidadMedida.builder().id(3L).denominacion("Gramos").build();

        ArticuloInsumo sal = ArticuloInsumo.builder().id(1L).denominacion("Sal").precioVenta(10.0).precioCompra(5.0).stockActual(100).stockMaximo(500).esParaElaborar(true).unidadMedida(kg).build();
        ArticuloInsumo aceite = ArticuloInsumo.builder().id(2L).denominacion("Aceite").precioVenta(50.0).precioCompra(30.0).stockActual(200).stockMaximo(400).esParaElaborar(true).unidadMedida(litro).build();
        ArticuloInsumo carne = ArticuloInsumo.builder().id(3L).denominacion("Carne").precioVenta(200.0).precioCompra(150.0).stockActual(50).stockMaximo(200).esParaElaborar(true).unidadMedida(kg).build();
        ArticuloInsumo harina = ArticuloInsumo.builder().id(4L).denominacion("Harina").precioVenta(80.0).precioCompra(40.0).stockActual(300).stockMaximo(600).esParaElaborar(true).unidadMedida(kg).build();

        Imagen img1 = Imagen.builder().id(1L).denominacion("HawainaPizza1").build();
        Imagen img2 = Imagen.builder().id(2L).denominacion("HawainaPizza2").build();
        Imagen img3 = Imagen.builder().id(3L).denominacion("HawainaPizza3").build();
        Imagen img4 = Imagen.builder().id(4L).denominacion("LomoCompleto1").build();
        Imagen img5 = Imagen.builder().id(5L).denominacion("LomoCompleto2").build();
        Imagen img6 = Imagen.builder().id(6L).denominacion("LomoCompleto3").build();

        ArticuloManufacturadoDetalle detallePizza1 = ArticuloManufacturadoDetalle.builder().id(1L).cantidad(1).insumo(sal).build();
        ArticuloManufacturadoDetalle detallePizza2 = ArticuloManufacturadoDetalle.builder().id(2L).cantidad(2).insumo(harina).build();
        ArticuloManufacturadoDetalle detallePizza3 = ArticuloManufacturadoDetalle.builder().id(3L).cantidad(1).insumo(aceite).build();

        ArticuloManufacturadoDetalle detalleLomo1 = ArticuloManufacturadoDetalle.builder().id(4L).cantidad(1).insumo(sal).build();
        ArticuloManufacturadoDetalle detalleLomo2 = ArticuloManufacturadoDetalle.builder().id(5L).cantidad(1).insumo(aceite).build();
        ArticuloManufacturadoDetalle detalleLomo3 = ArticuloManufacturadoDetalle.builder().id(6L).cantidad(1).insumo(carne).build();

        ArticuloManufacturado pizzaHawaina = ArticuloManufacturado.builder()
                .id(10L).denominacion("Pizza Hawaiana").precioVenta(1200.0)
                .descripcion("Pizza con ananá y jamón")
                .tiempoEstimadoMinutos(20).preparacion("Horno de leña")
                .categoria(catPizzas)
                .build();
        pizzaHawaina.addImagen(img1);
        pizzaHawaina.addImagen(img2);
        pizzaHawaina.addImagen(img3);
        pizzaHawaina.addDetalle(detallePizza1);
        pizzaHawaina.addDetalle(detallePizza2);
        pizzaHawaina.addDetalle(detallePizza3);

        ArticuloManufacturado lomoCompleto = ArticuloManufacturado.builder()
                .id(20L).denominacion("Lomo Completo").precioVenta(1500.0)
                .descripcion("Lomo completo con papas fritas")
                .tiempoEstimadoMinutos(25).preparacion("Plancha")
                .categoria(catLomos)
                .build();
        lomoCompleto.addImagen(img4);
        lomoCompleto.addImagen(img5);
        lomoCompleto.addImagen(img6);
        lomoCompleto.addDetalle(detalleLomo1);
        lomoCompleto.addDetalle(detalleLomo2);
        lomoCompleto.addDetalle(detalleLomo3);

        ArticuloManufacturadoRepository repoArt = new ArticuloManufacturadoRepository();
        repoArt.addArticulo(pizzaHawaina);
        repoArt.addArticulo(lomoCompleto);

        System.out.println("\n//// CATEGORÍAS ////");
        System.out.println(catPizzas);
        System.out.println(catLomos);
        System.out.println(catInsumos);

        System.out.println("\n//// INSUMOS ////");
        System.out.println(sal);
        System.out.println(aceite);
        System.out.println(carne);
        System.out.println(harina);

        System.out.println("\n//// MANUFACTURADOS ////");
        repoArt.mostrarTodos();

        System.out.println("\n//// BUSCAR MANUFACTURADO ID=10 ////");
        System.out.println(repoArt.buscarPorId(10L));

        System.out.println("\n//// ACTUALIZAR MANUFACTURADO ////");
        repoArt.actualizar(10L, "Pizza Hawaiana Especial");
        repoArt.mostrarTodos();

        System.out.println("\n//// ELIMINAR MANUFACTURADO ////");
        repoArt.eliminarPorId(20L);
        repoArt.mostrarTodos();

        sucursal1.addArticulo(pizzaHawaina);
        sucursal1.addArticulo(sal);
        sucursal2.addArticulo(lomoCompleto);

        System.out.println("\n//// ARTÍCULOS DE SUCURSAL 1 ////");
        sucursal1.getArticulos().forEach(System.out::println);
    }
}
