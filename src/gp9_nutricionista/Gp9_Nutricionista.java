package gp9_nutricionista;



import gp9_nutricionista.modelo.*;
import nutricionista_persistencia.*;


public class Gp9_Nutricionista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       PacienteData pD = new PacienteData();
       Paciente p1 = new Paciente("Fernando", 33, 180, 120, 85);
       Paciente P2 = new Paciente(1, "Jose", 25, 170, 70, 68);
       
       
       
       //.agregarPaciente(p1);
       pD.modificarPaciente(P2);
       
       
    }
    
}
