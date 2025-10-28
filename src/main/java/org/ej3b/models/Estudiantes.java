package org.ej3b.models;

public class Estudiantes {
    int matricula;
    String nombre;
    int edad [];
    Materia mat[];
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getEdad() {
        return edad;
    }

    public void setEdad(int[] edad) {
        this.edad = edad;
    }

    public Materia[] getMat(){
        return this.mat;
    }

    public void setMat(Materia[] m){
        this.mat = m;
    }
}
