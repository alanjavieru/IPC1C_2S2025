# Proyecto 1: Sistema de Inventario

Sistema de gestión de inventario para una tienda de ropa desarrollado en Java. Permite gestionar productos, registrar ventas, generar reportes en PDF y mantener una bitácora de actividades.


## Requisitos 
- Java JDK 8 o superior
- IDE (NetBeans recomendado)
- Git para control de versiones

## Instalación

1. Clonar el repositorio

```bash
git clone https://github.com/alanjavieru/IPC1C_2S2025.git
```
    
2. Navegar al directorio del proyecto 
```bash
cd IPC1C_2S2025/Proyecto1
```

3. Compilar el proyecto 
```bash
javac -d bin src/*.java
```

4. Ejecutar la aplicación
```bash
java -cp bin Proyecto1 
```
## Uso

### Menú Principal
Al ejecutar la aplicación, se mostrará el siguiente menú:

-------- Menú ---------
1. Agregar producto 
2. Buscar producto
3. Eliminar producto 
4. Registrar venta
5. Bitácora
6. Generar reportes
7. Ver datos de estudiante
8. Salir

### Funcionalidades  
1. Agregar producto 
- Solicitud de código único, nombre, categoría, precio y cantidad
- Validación de código y cantidades positivas
- Almacenamiento en inventario

2. Buscar producto
- Permite búsqueda por código, nombre o categoría
- Muestra de resultados
- Indicación si no se encuentran productos


3. Eliminar producto
- Buscar producto por código
- Solicitud de confirmación
- Actualización de inventario

4. Registrar venta
- Validación de existencia del producto y stock
- Calculo total y actualización de inventario
- Se registra la transacción

5. Bitácora
- Muestra registro de todas las actividades
- Incluye fecha, tipo de acción y estado.

6. Generar reportes
- Reporte de stock: lista completa de productos
- Reporte de ventas: Historial de transacciones
- Nombres con formato: DD_MM_YYYY_HH_mm_ss_[Tipo].pdf

7. Ver datos de estudiante
- Muestra información del desarrollador
- Incluye nombre, carné y sección

## Problemas conocidos

## Mejoras futuras

## Información del Estudiante
**Nombre:** Alan Javier García Pérez

**Carné:** 202101135

**Curso:** Introducción a la Programación y Computación 1
