# Parcial3-Jordan
2. Dime con tus propias palabras porque en el punto 1 semenciona que esto es confuso. Usar las palabras adecuadas y respuesta exacta.
Respuesta: Decimos que esto es confuso ya que estamos desarrollando este programa pensando en el usuario por lo cual debemos de hacer todo de la manera más sencilla posible para que el usuario lo pueda usar correctamente, por esto decimos que tenemos que hacer un diagrama de proceso el cual tendrá toda la información de manera clara, detallada y paso a paso

## EndPoints
Aqui estaran todos los endpoints necesarios para el funcionamiento del programa
### Visualizacion
. /libros Muestra todos los libros
. /copias Muestra las copias que tienen los libros
. /lectores Muestra todos los lectores creados
. /prestamos Muestra los prestamos (No alcanzo el tiempo para la implementacion)
### Agregados
. /agregarLibro/:nombre/:tipo/:editorial/:anio agrega un libro y pide de parametro su nombre, el tipo/genero, la editorial y el año
. /agregarAutor/:nombre/:nacionalidad/:fechaNacimiento Agrega un autor
. /agregarLector/:nombre/:nacionalidad/:fechaNacimiento Agrega un lector
### Interacción
. /guardarDatos Se usa para guardar los datos en un archivo de texto, usando la serializacion (pertinencia)
. /prestarLibro/:idLibro/:identificadorLector Sirve para prestar un libro
. //devolverLibro/:idLibro/:identificadorLector Sirve para devolver un libro
