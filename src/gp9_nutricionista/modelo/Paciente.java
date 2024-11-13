/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp9_nutricionista.modelo;

/**
 *
 * @author agust
 */
public class Paciente {
    private int nroPaciente;
    private String nombre;
    private int edad;
    private float altura;
    private float pesoActual;
    private float pesoBuscado;
    private boolean estado;

    public Paciente() {
    }

    public Paciente(int nroPaciente, String nombre, int edad, float altura, float pesoActual, float pesoBuscado, boolean estado) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.estado = estado;
    }

    public Paciente(String nombre, int edad, float altura, float pesoActual, float pesoBuscado, boolean estado) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
        this.estado = estado;
    }

    
    public Paciente(int nroPaciente, String nombre, int edad, float altura, float pesoActual, float pesoBuscado) {
        this.nroPaciente = nroPaciente;
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
    }

    public Paciente(String nombre, int edad, float altura, float pesoActual, float pesoBuscado) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNroPaciente() {
        return nroPaciente;
    }

    public void setNroPaciente(int nroPaciente) {
        this.nroPaciente = nroPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(float pesoActual) {
        this.pesoActual = pesoActual;
    }

    public float getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(float pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nroPaciente=" + nroPaciente + ", nombre=" + nombre + ", edad=" + edad + ", altura=" + altura + ", pesoActual=" + pesoActual + ", pesoBuscado=" + pesoBuscado + '}';
    }
    
}
