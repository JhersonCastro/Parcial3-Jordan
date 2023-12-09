package com.mycompany.biblioteca;

import java.io.Serializable;
import java.util.LinkedList;

public class Inventory implements Serializable {
    public LinkedList<Libro> libros = new LinkedList<>();

    public LinkedList<Autor> autoresLibro1 = new LinkedList<>();
    public LinkedList<Autor> autoresGenericos = new LinkedList<>();
    public LinkedList<Autor> autores = new LinkedList<>();

    public LinkedList<Copia> copias = new LinkedList<>();
    public LinkedList<Lector> lectores = new LinkedList<>();

    public LinkedList<Prestamo> prestamos = new LinkedList<>();

    public LinkedList<Multa> multas = new LinkedList<>();

}
