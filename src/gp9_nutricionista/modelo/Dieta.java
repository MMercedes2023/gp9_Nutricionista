/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp9_nutricionista.modelo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author agust
 */
public class Dieta {
    private int codDieta;
    private String nombreD;
    private List<MenuDiario> menus;
    private LocalDate fechaIni;
    private LocalDate fechaFin;
    private float pesoFinal;
    private boolean estado;
    
    private int totalCalorias;
    private Paciente paciente;

    public Dieta() {
    }

    public Dieta(int codDieta, String nombreD, List<MenuDiario> menus, LocalDate fechaIni, LocalDate fechaFin, float pesoFinal, boolean estado, int totalCalorias, Paciente paciente) {
        this.codDieta = codDieta;
        this.nombreD = nombreD;
        this.menus = menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
    }

    public Dieta(String nombreD, List<MenuDiario> menus, LocalDate fechaIni, LocalDate fechaFin, float pesoFinal, boolean estado, int totalCalorias, Paciente paciente) {
        this.nombreD = nombreD;
        this.menus = menus;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.pesoFinal = pesoFinal;
        this.estado = estado;
        this.totalCalorias = totalCalorias;
        this.paciente = paciente;
    }

    public int getCodDieta() {
        return codDieta;
    }

    public void setCodDieta(int codDieta) {
        this.codDieta = codDieta;
    }

    public String getNombreD() {
        return nombreD;
    }

    public void setNombreD(String nombreD) {
        this.nombreD = nombreD;
    }

    public List<MenuDiario> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuDiario> menus) {
        this.menus = menus;
    }

    public LocalDate getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(LocalDate fechaIni) {
        this.fechaIni = fechaIni;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(float pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(int totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Dieta{" + "codDieta=" + codDieta + ", nombreD=" + nombreD + ", menus=" + menus + ", fechaIni=" + fechaIni + ", fechaFin=" + fechaFin + ", pesoFinal=" + pesoFinal + ", estado=" + estado + ", totalCalorias=" + totalCalorias + ", paciente=" + paciente + '}';
    }
    
    
}
