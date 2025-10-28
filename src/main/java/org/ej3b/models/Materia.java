package org.ej3b.models;

public class Materia {
    String clave;
    String nombre;
    int creditos;

    public Materia(String clave, String nombre, int creditos){
        this.clave = clave;
        this.nombre = nombre;
        this.creditos = creditos;
    }
    public Materia(){}

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
