package nutricionista_persistencia;

import java.sql.Connection;
import gp9_nutricionista.modelo.Dieta;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DietaData {
    
    private Connection con=null;
    private PacienteData pD = new PacienteData();
    

public DietaData(){

    con = Conexion.getConexion();

}

public void guardarDieta(Dieta dieta){
    
String sql= "INSERT INTO dieta (nombreD,fechaInicio,fechaFin,pesoFinal,estado,totalCalorias,nroPaciente)VALUES(?,?,?,?,?,?,?)";

    try{
    PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    ps.setString(1, dieta.getNombreD());
    ps.setDate(2,Date.valueOf(dieta.getFechaIni()));
    ps.setDate(3,Date.valueOf(dieta.getFechaFin()));
    ps.setFloat(4,dieta.getPesoFinal());
    ps.setBoolean(5,dieta.isEstado());
    ps.setInt(6, dieta.getTotalCalorias());
    ps.setInt(7, dieta.getPaciente().getNroPaciente());
    
    ps.executeUpdate();
    ResultSet rs= ps.getGeneratedKeys();
    if(rs.next()){
    
    
    JOptionPane.showMessageDialog(null," Su dieta se guardo correctamente ");
    
    }
    ps.close();
    } catch (SQLException ex){
    
    JOptionPane.showMessageDialog(null,"Error al acceder a  dieta "+ex.getMessage());
    
    }
    
    
    
}
    public Dieta buscarDietaPorId(int codDieta) {

        Dieta dieta = null;
        String sql = "SELECT nombreD,fechaInicio,fechaFin,pesoFinal,totalCalorias,nroPaciente FROM dieta WHERE codDieta =? AND estado=1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, codDieta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dieta=new Dieta();
                dieta.setCodDieta(codDieta);
                dieta.setNombreD(rs.getString("nombreD"));
                dieta.setFechaIni(rs.getDate("fechaInicio").toLocalDate());
                dieta.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoFinal(rs.getFloat("pesoFinal"));
                dieta.setTotalCalorias(rs.getInt("totalCalorias"));
                dieta.setPaciente(pD.buscarPaciente(rs.getInt("nroPaciente")));
                dieta.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe la dieta");
        
        }
            ps.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a  dieta " + ex.getMessage());
        }
        return dieta;

    }



public void modificarDieta(Dieta dieta){
   
  String sql= "UPDATE dieta SET nombreD=?,fechaInicio=?,fechaFin=?,pesoFinal=?,totalCalorias=?,nroPaciente=? WHERE CodDieta=?";
    PreparedStatement ps=null;
    try{
    ps=con.prepareStatement(sql);
    ps.setString(1,dieta.getNombreD());
    ps.setDate(2, Date.valueOf(dieta.getFechaIni()));
    ps.setDate(3,Date.valueOf(dieta.getFechaFin()));
    ps.setFloat(4,dieta.getPesoFinal());
    ps.setFloat(5, dieta.getTotalCalorias());
    ps.setInt(6, dieta.getPaciente().getNroPaciente());
    ps.setInt(7, dieta.getCodDieta());
    int exito=ps.executeUpdate();
    
    if(exito==1){
    JOptionPane.showMessageDialog(null," Su dieta se ha sido modificada éxitosamente ");
    }else{
    JOptionPane.showMessageDialog(null," La dieta que intenta modificar no existe ");
   
    }
    }catch(SQLException ex){
    JOptionPane.showMessageDialog(null,"Error al acceder a  dieta "+ex.getMessage());
    }
    }
    
    


public void eliminarDieta(int codDieta) {
    try {
       
        String sql = "UPDATE dieta SET estado = 0 WHERE codDieta = ?";
        
        
        PreparedStatement ps = con.prepareStatement(sql);
        
    
        ps.setInt(1, codDieta);
        
      
        int fila = ps.executeUpdate();
        
        
        if (fila == 1) {
            JOptionPane.showMessageDialog(null, "Su dieta se elimino");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro la dieta");
        }

        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a dieta: " + ex.getMessage());
    }
}

}
