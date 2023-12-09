package com.mycompany.biblioteca;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author JMINOTA
 */
public class Copia extends Libro implements Serializable {
    
    
    /**
     * ESTADO (DISPONIBLE - PRESTADO)
     * PUEDE SER BOOL TRUE=DISPONIBLE FALSE=PRESTADO
     **/
    int id;
    boolean estado;

    public boolean isEstado() {
        return estado;
    }

    public Copia(int id, String nombre, String tipo, String editorial, int anio, LinkedList<Autor> autores) {
        super(nombre, tipo, editorial, anio, autores);
        this.id = id;
        this.estado = true;
    }
    public void prestar(Lector lector){
        if(estado){
            lector.asignarCopia(this);
        }
    }
    public void devolver(Lector lector){
        if(!estado)
                lector.devolverCopia(this);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public LinkedList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(LinkedList<Autor> autores) {
        this.autores = autores;
    }
}
