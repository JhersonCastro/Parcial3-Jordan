package com.mycompany.biblioteca;

import static spark.Spark.*;

import com.google.gson.Gson;

import java.util.*;
import java.time.LocalDate;

public class Biblioteca {
    static int indiceCopia = 1;

    public static void main(String[] args) {


        Gson gson = new Gson();
        GestionInventory gestionInventory = new GestionInventory();
        Inventory inventory = gestionInventory.cargarDesdeArchivo("Gestion.ser");


        get("/libros", (req, res) -> {
            res.type("application/json");
            return gson.toJson(inventory.libros);
        });

        get("/copias", (req, res) -> {
            res.type("application/json");
            return gson.toJson(inventory.copias);
        });

        get("/lectores", (req, res) -> {
            res.type("application/json");
            return gson.toJson(inventory.lectores);
        });
        get("/guardarDatos", (req, res) -> {
            res.type("application/json");
            gestionInventory.guardarEnArchivo(inventory, "Gestion.ser");
            return gson.toJson("Se guardaron correctamente los datos");
        });

        get("/prestamos", (req, res) -> {
            res.type("application/json");
            return gson.toJson(inventory.prestamos);
        });
        get("/agregarLibro/:nombre/:tipo/:editorial/:anio", (req, res) -> {
            res.type("application/json");
            String nombre = req.params(":nombre");
            String tipo = req.params(":tipo");
            String editorial = req.params(":editorial");
            int anio = 0;
            try {
                anio = Integer.parseInt(req.params(":anio"));
            } catch (Exception ignored) {
            }
            Libro tmpLibro = new Libro(nombre, tipo, editorial, anio, inventory.autoresGenericos);
            inventory.libros.add(tmpLibro);
            inventory.copias.add(new Copia(indiceCopia, tmpLibro.nombre, tmpLibro.getTipo(), tmpLibro.editorial, tmpLibro.anio, tmpLibro.autores));
            indiceCopia++;
            inventory.copias.add(new Copia(indiceCopia, tmpLibro.nombre, tmpLibro.getTipo(), tmpLibro.editorial, tmpLibro.anio, tmpLibro.autores));
            indiceCopia++;
            return gson.toJson(inventory.copias);
        });
        get("/agregarAutor/:nombre/:nacionalidad/:fechaNacimiento", (req, res) -> {
            res.type("application/json");

            String nombre = req.params(":nombre");
            String nacionalidad = req.params(":nacionalidad");
            String fechaNacimiento = req.params(":fechaNacimiento");
            Autor nuevoAutor = new Autor(nombre, nacionalidad, fechaNacimiento, inventory.libros);
            inventory.autores.add(nuevoAutor);
            return gson.toJson(nuevoAutor);
        });
        get("/agregarLector/:nombre/:nacionalidad/:fechaNacimiento", (req, res) -> {
            res.type("application/json");

            String nombre = req.params(":nombre");
            String apellido = req.params(":apellido");
            String direccion = req.params(":direccion");
            Lector nuevoLector = new Lector(nombre, apellido, direccion);
            inventory.lectores.add(nuevoLector);
            return gson.toJson(inventory.lectores);
        });
            get("/devolverLibro/:idLibro/:identificadorLector", (req, res) -> {
            res.type("application/json");

            int idLibro = Integer.parseInt(req.params(":idLibro"));
            String identificador = req.params(":identificadorLector");
            Copia tmpCopia = searchCopiaById(idLibro, inventory);
            if (tmpCopia != null) {
                Lector tmpLector = searchLectorById(identificador, inventory);
                if (tmpLector != null) {
                    tmpCopia.devolver(tmpLector);
                    System.out.println("Yeix|");
                    return gson.toJson(tmpLector);

                }
            }
            return gson.toJson(inventory.lectores);
        });
        get("/prestarLibro/:idLibro/:identificadorLector", (req, res) -> {
            res.type("application/json");
            int idLibro = Integer.parseInt(req.params(":idLibro"));

            String identificador = req.params(":identificadorLector");
            Copia tmpCopia = searchCopiaById(idLibro, inventory);
            if (tmpCopia != null) {
                Lector tmpLector = searchLectorById(identificador, inventory);
                if (tmpLector != null) {
                    tmpCopia.prestar(tmpLector);
                }
            }
            return gson.toJson(inventory.lectores);
        });

    }

    public static Lector searchLectorById(String ID, Inventory inventory) {
        Optional<Lector> theSubject = inventory.lectores.stream().filter(std -> std.identificador.equals(ID)).findFirst();
        return theSubject.orElse(null);
    }

    public static Copia searchCopiaById(int ID, Inventory inventory) {
        Optional<Copia> theSubject = inventory.copias.stream().filter(std -> std.id == ID).findFirst();
        return theSubject.orElse(null);
    }

    public static Libro addLibro(String nombre, String tipo, String editorial, int anio, LinkedList<Autor> autores) {
        Libro libro = new Libro(nombre, tipo, editorial, anio, autores);
        return libro;
    }

    public static Autor addAutor(String nombre, String nacionalidad, String hbd, LinkedList<Libro> libros) {
        Autor autor = new Autor(nombre, nacionalidad, hbd, libros);
        return autor;
    }

    public static Copia addCopia(int id, String nombre, String tipo, String editorial, int anio, LinkedList<Autor> autores) {
        Copia copia = new Copia(id, nombre, tipo, editorial, anio, autores);
        return copia;
    }

    public static Lector addLector(String nombre, String apellido, String dir) {
        // dejamos el ultimo en null porque este no tiene multas apenas lo creamos
        Lector lector = new Lector(nombre, apellido, dir);
        return lector;
    }

    public static Prestamo nuevoPrestamo(int id, int fechaInicio, int fechaFin, Copia copia, Lector lector) {
        Prestamo prestamo = new Prestamo(id, fechaInicio, fechaFin, copia, lector);
        return prestamo;
    }

    public static Multa nuevaMulta(int id, int fechaInicio, int fechaFin, Lector lector, Prestamo prestamo) {
        Multa multa = new Multa(id, fechaInicio, fechaFin, lector, prestamo);
        return multa;
    }

}
