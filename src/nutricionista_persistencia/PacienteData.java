/*

 */
package nutricionista_persistencia;

import gp9_nutricionista.modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
    
    
    public void agregarPacienteId(Paciente paciente){
    
    String sql = "INSERT INTO paciente (nroPaciente, nombre, edad, altura, pesoActual, pesoBuscado)"+ " VALUES(?,?,?,?,?,?)";
    
    try{
    PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    ps.setInt(1, paciente.getNroPaciente());
    ps.setString(2, paciente.getNombre());
    ps.setInt(3, paciente.getEdad());
    ps.setFloat(4, paciente.getAltura());
    ps.setFloat(5, paciente.getPesoActual());
    ps.setFloat(6, paciente.getPesoBuscado());
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
     
     public Paciente buscarPaciente(int id) {
        Paciente paciente = new Paciente();
        String sql = "SELECT * FROM paciente WHERE nroPaciente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setNroPaciente(id);
                paciente.setNombre(rs.getString("nombre"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro al paciente");
            }

            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al buscar paciente");
        }

        return paciente;
    }
     
      public List<Paciente> listarPacientes() {

        String sql = "SELECT * FROM paciente";
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setAltura(rs.getFloat("altura"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setNroPaciente(rs.getInt("nroPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setPesoActual(rs.getFloat("pesoActual"));
                paciente.setPesoBuscado(rs.getFloat("pesoBuscado"));
                pacientes.add(paciente);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al mostrar la lista");

        }

        return pacientes;
    }
  public void borrarPaciente(int nroPaciente) {
    String sql = "DELETE FROM paciente WHERE nroPaciente=?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, nroPaciente);
        
        int x = ps.executeUpdate();
        
        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Paciente eliminado");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el paciente ");
        }
        
        ps.close();
    } catch (SQLException ex) {
       
        JOptionPane.showMessageDialog(null, "No se pudo eliminar el paciente: " + ex.getMessage());
    }
}
   
   
}
