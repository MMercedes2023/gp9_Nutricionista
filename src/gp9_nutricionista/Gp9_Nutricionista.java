package gp9_nutricionista;

import gp9_nutricionista.modelo.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import nutricionista_persistencia.*;
public class Gp9_Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        // TODO code application logic here
       PacienteData pD = new PacienteData();
       DietaData dD = new DietaData();
       Paciente p1 = new Paciente("Fernando", 33, 180, 120, 85);
       Paciente P2 = new Paciente(1, "Jose", 25, 170, 70, 68);
       Comida c1 = new Comida("Banana", "asdas", 20, "detalle", true);
       Comida c2 = new Comida("Pastel en fuente", "a", 50, "carne", true);
       
     
      
       
       RenglonDeMenu r1 = new RenglonDeMenu(c2, 15, 30);
       RenglonDeMenu r2 = new RenglonDeMenu(c1, 11, 14);
        ArrayList<RenglonDeMenu> renglones = new ArrayList<>();
        Dieta dieta1 = new Dieta("Luna", LocalDate.of(2024, 10, 31), LocalDate.of(2024, 12, 28), 90, true, 1200, P2);
        MenuDiario M1 = new MenuDiario(1, renglones, true, dieta1);
       
       dieta1.agregarMenus(M1);
       
       
       //.agregarPaciente(p1);
       //pD.modificarPaciente(P2);
        //System.out.println(pD.buscarPaciente(1));
        
        for (Paciente p : pD.listarPacientes()) {
            System.out.println(p);
        }
       //pD.borrarPaciente(1);
       
       dD.guardarDieta(dieta1);
       
       
       
       
       
    }
    
}
