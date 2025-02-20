# Proyecto de Automatización de Pruebas

## Descripción
Este proyecto tiene como objetivo automatizar los flujos de prueba más críticos para la tienda en línea [OpenCart](https://opencart.abstracta.us). La automatización se realiza para reducir el tiempo de ejecución y mejorar la cobertura de pruebas.

## Requerimientos
- **Java JDK 17** o superior
- **Eclipse IDE**
- **ChromeDriver** (debe ser compatible con la versión de Chrome instalada)

## Funcionalidades Automatizadas
1. Completar el formulario de registro.
2. Validar el inicio de sesión.
3. Probar el restablecimiento de contraseña.
4. Navegar a la sección de Laptops & Notebooks y seleccionar "Show all laptops & notebooks".
5. Agregar al carrito de compras un portátil MacBook Pro.
6. Usar la barra de búsqueda para encontrar una tablet Samsung Galaxy y agregarla al carrito de compras.
7. Eliminar la MacBook Pro del carrito.
8. Agregar otra unidad de la tablet Samsung Galaxy.
9. Completar el proceso de compra hasta la confirmación de la orden.

## Instalación y Configuración
1. Instala el **JDK**.
2. Instala **Eclipse IDE**.
3. Configura un proyecto **Maven** e incluye las dependencias necesarias.
4. Instala **ChromeDriver** y asegúrate de que su ruta esté configurada correctamente.
5. Configura el compilador de Java en Eclipse a la **versión 17**.

   Nota: Con importar las carpetas y los archivos deberia funcionar la ejecución

## Ejecución de Pruebas
Para ejecutar cada prueba, utiliza JUnit:
- Haz clic derecho sobre la clase de prueba en Eclipse.
- Selecciona **Run As** > **JUnit Test**.
