# inventory-pro

# descripción
InventoryPro es una aplicación web simple pero efectiva que ayuda a los dueños de pequeñas tiendas a gestionar su inventario de manera eficiente. Muchas tiendas de barrio aún llevan sus registros en papel o en hojas de cálculo poco organizadas, lo que dificulta el seguimiento preciso de sus productos, ventas y reabastecimiento. InventoryPro resuelve este problema ofreciendo una solución fácil de usar y accesible para gestionar el inventario, registrar ventas y generar informes básicos.

# Historias de Usuario

## HU-001: Agregar nuevos productos al inventario

Como dueño de tienda, quiero poder agregar nuevos productos a mi inventario.

### Criterios de Aceptación:
- [x] Puedo ingresar el nombre, descripción, precio y cantidad del producto.
- [x] El sistema asigna automáticamente un ID único al producto.
- [x] Recibo una confirmación cuando el producto se agrega exitosamente.

## HU-002: Ver lista de productos en inventario

Como dueño de tienda, quiero ver una lista de todos los productos en mi inventario.

### Criterios de Aceptación:
- [ ] Puedo ver una lista paginada de todos los productos.
- [ ] La lista muestra el ID, nombre, precio y cantidad disponible de cada producto.
- [ ] Puedo ordenar la lista por nombre, precio o cantidad.

## HU-003: Actualizar información de productos existentes

Como dueño de tienda, quiero actualizar la información de un producto existente.

### Criterios de Aceptación:
- [ ] Puedo buscar un producto por su ID o nombre.
- [ ] Puedo modificar el nombre, descripción, precio y cantidad del producto.
- [ ] Recibo una confirmación cuando la información se actualiza correctamente.

## HU-004: Registrar venta de productos

Como dueño de tienda, quiero registrar una venta de productos.

### Criterios de Aceptación:
- [ ] Puedo crear una nueva venta especificando los productos y cantidades vendidas.
- [ ] El sistema actualiza automáticamente las cantidades en el inventario.
- [ ] Recibo un resumen de la venta, incluyendo el total.

## HU-005: Ver informe básico de ventas

Como dueño de tienda, quiero ver un informe básico de ventas.

### Criterios de Aceptación:
- [ ] Puedo ver el total de ventas en un periodo específico (día, semana, mes).
- [ ] El informe muestra los productos más vendidos y los que generan más ingresos.
- [ ] Puedo ver el informe en formato JSON para facilitar su integración con otras herramientas.