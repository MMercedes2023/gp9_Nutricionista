/*

 */
package nutricionista_persistencia;

import gp9_nutricionista.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author agust
 */
public class PacienteData {
     private Connection con = null;
    
    public PacienteData () {
        con = Conexion.getConexion();
        
    }
    
    
    public void agregarPaciente(Paciente paciente){
    
    String sql = "INSERT INTO paciente (nombre, edad, altura, pesoActual, pesoBuscado)"+ " VALUES(?,?,?,?,?)";
    
    try{
    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setString(1, paciente.getNombre());
    ps.setInt(2, paciente.getEdad());
    ps.setFloat(3, paciente.getAltura());
    ps.setFloat(4, paciente.getPesoActual());
    ps.setFloat(5, paciente.getPesoBuscado());
    ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setNroPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente añadido con éxito");
            }
            ps.close();
    
    
    
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null, "Error al guardar el paciente");
    
    }
    }
    
     public void modificarPaciente(Paciente paciente){
        
    String sql="UPDATE paciente SET nombre=?,edad=?,altura=?,pesoActual=?, pesoBuscado=? WHERE nroPaciente=?";
    
  
    
    try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, paciente.getNombre());
           ps.setInt(2, paciente.getEdad());
           
           ps.setFloat(3, paciente.getAltura());
           ps.setFloat(4, paciente.getPesoActual());
           ps.setFloat(5, paciente.getPesoBuscado());
           ps.setInt(6, paciente.getNroPaciente());
            int x = ps.executeUpdate();

            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Paciente modificado con exito");
            } else {
            JOptionPane.showMessageDialog(null, "No se encontró el paciente");
        }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al  modificar el paciente" + ex);
        }
    }
    
}
