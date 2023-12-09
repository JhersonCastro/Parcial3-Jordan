package com.mycompany.biblioteca;

import java.io.*;

public class GestionInventory implements Serializable {
    public void guardarEnArchivo(Inventory sistema, String file){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(sistema);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Se guardaron correctamente los datos");
        }catch (Exception ex){
            System.out.println("Ocurrio un error" + ex.getMessage());
        }
    }
    public Inventory cargarDesdeArchivo(String nombreArchivo){

        Inventory inventory = new Inventory();
        try {
            FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            inventory = (Inventory) in.readObject();
            in.close();
            fileInputStream.close();
            System.out.println("Se cargaron correctamente los datos");
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return inventory;
    }
}
