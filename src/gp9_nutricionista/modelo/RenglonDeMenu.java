/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp9_nutricionista.modelo;

/**
 *
 * @author agust
 */
public class RenglonDeMenu {
    private int nroRenglon;
    private Comida alimento;
    private double cantidadGrs;
    private int subtotalCalorias;

    public RenglonDeMenu() {
    }

    public RenglonDeMenu(int nroRenglon, Comida alimento, double cantidadGrs, int subtotalCalorias) {
        this.nroRenglon = nroRenglon;
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subtotalCalorias = subtotalCalorias;
    }

    public RenglonDeMenu(Comida alimento, double cantidadGrs, int subtotalCalorias) {
        this.alimento = alimento;
        this.cantidadGrs = cantidadGrs;
        this.subtotalCalorias = subtotalCalorias;
    }

    public int getNroRenglon() {
        return nroRenglon;
    }

    public void setNroRenglon(int nroRenglon) {
        this.nroRenglon = nroRenglon;
    }

    public Comida getAlimento() {
        return alimento;
    }

    public void setAlimento(Comida alimento) {
        this.alimento = alimento;
    }

    public double getCantidadGrs() {
        return cantidadGrs;
    }

    public void setCantidadGrs(double cantidadGrs) {
        this.cantidadGrs = cantidadGrs;
    }

    public int getSubtotalCalorias() {
        return subtotalCalorias;
    }

    public void setSubtotalCalorias(int subtotalCalorias) {
        this.subtotalCalorias = subtotalCalorias;
    }

    @Override
    public String toString() {
        return "RenglonDeMenu{" + "nroRenglon=" + nroRenglon + ", alimento=" + alimento + ", cantidadGrs=" + cantidadGrs + ", subtotalCalorias=" + subtotalCalorias + '}';
    }
    
    
    
    
}
