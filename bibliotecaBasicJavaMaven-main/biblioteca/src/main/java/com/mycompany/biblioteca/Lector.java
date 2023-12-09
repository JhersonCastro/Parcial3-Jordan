/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;

/**
 *
 * @author JMINOTA
 */
public class Lector implements Serializable {
    ArrayList<Copia> copias;
    String identificador; // numSocio
    String nombre, apellido, dir;
    Multa multa;

    public ArrayList<Copia> getCopias() {
        return copias;
    }

    public void setCopias(ArrayList<Copia> copias) {
        this.copias = copias;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Lector(String nombre, String apellido, String dir) {
        this.identificador = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dir = dir;
        copias = new ArrayList<>();
    }

    public void asignarCopia(Copia copia){
        if(copias.size() < 3){
            copias.add(copia);
            System.out.println("Se ha agregado la copia");
        }else
            System.out.printf("Ha ocurrido un error");
    }
    public void devolverCopia(Copia copia){
        copias.remove(copia);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    
    
}
