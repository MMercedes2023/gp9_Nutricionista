/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gp9_nutricionista.modelo;

import java.util.List;

/**
 *
 * @author agust
 */
public class MenuDiario {
    private int codMenu;
    
    private int diaNro;
    private List<RenglonDeMenu> comidas;
    private boolean estado;
    private Dieta dieta;

    public MenuDiario(int codMenu, int diaNro, List<RenglonDeMenu> comidas, boolean estado, Dieta dieta) {
        this.codMenu = codMenu;
        this.diaNro = diaNro;
        this.comidas = comidas;
        this.estado = estado;
        this.dieta = dieta;
    }

    public MenuDiario(int diaNro, List<RenglonDeMenu> comidas, boolean estado, Dieta dieta) {
        this.diaNro = diaNro;
        this.comidas = comidas;
        this.estado = estado;
        this.dieta = dieta;
    }

    public int getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(int codMenu) {
        this.codMenu = codMenu;
    }

    public int getDiaNro() {
        return diaNro;
    }

    public void setDiaNro(int diaNro) {
        this.diaNro = diaNro;
    }

    public List<RenglonDeMenu> getComidas() {
        return comidas;
    }

    public void setComidas(List<RenglonDeMenu> comidas) {
        this.comidas = comidas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Dieta getDieta() {
        return dieta;
    }

    public void setDieta(Dieta dieta) {
        this.dieta = dieta;
    }

    @Override
    public String toString() {
        return "MenuDiario{" + "codMenu=" + codMenu + ", diaNro=" + diaNro + ", comidas=" + comidas + ", estado=" + estado + ", dieta=" + dieta + '}';
    }
    
    
    
}
