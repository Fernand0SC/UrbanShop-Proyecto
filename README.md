# Urban Shop

**Proyecto Semestral - Desarrollo FullStack 1**

###   Integrantes
* **Fernando Serrano:** Gestión de Clientes | Catálogo e Inventario
* **Matias Muñoz:** Carrito y Órdenes | Pasarela de Pagos
* **Melissa Vergara:** Despachos y Logística | Postventa e Incidencias
* **Manuel Gaete:** Alertas y Mensajería | Lista de Deseos

### Dependencias
* Spring Web
* Spring Data JPA
* MySQL Driver
* Flyway
* Validation
* OpenFeign
* Logback
* Lombok

### Cómo ejecutar
1. Asegurarse de tener MySQL corriendo.
2. Crear una base de datos distinta para cada microservicio.
    Cliente = db_UrbanShop_Cliente
    Catalogo = db_UrbanShop_Catalogo
3. En la carpeta de cada microservicio, correr el programa