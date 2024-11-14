package nutricionista_persistencia;

/**
 *
 * @author ACER
 */
import gp9_nutricionista.modelo.Comida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ComidaData {

    private Connection con = null;
    
    

    public ComidaData() {
        con = Conexion.getConexion();
    }


    public static List<Comida> filtrarNombre(String nombre) {
        List<Comida> nombresComida = new ArrayList<>();
        String sql = "SELECT nombre FROM comida WHERE codDieta =? AND baja=1";

        try {
            PreparedStatement ps = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nombresComida.add(new Comida(
                        rs.getString("nombre")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a  los nombres: " + e.getMessage());
        }
        return nombresComida;
    }

    

    public void modificarAlimento(Comida comida) {
        String sql = "UPDATE comida SET nombre = ?, caloriasPor100g = ?, tipoComida = ?, detalle = ?, baja=? WHERE codComida = ?";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNombre());
            ps.setInt(2, comida.getCaloriasPor100g());
            ps.setString(3, comida.getTipoComida());
            ps.setString(4, comida.getDetalle());
            ps.setBoolean(5, comida.isBaja());
            ps.setInt(6, comida.getConComida());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El alimento se ha sido modificada éxitosamente ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al alimento:  " + ex.getMessage());
        }
    }
    
    
    public void guardarComida(Comida comida){
     
        String sql = "INSERT INTO comida (nombre, tipoComida, caloriasPor100g, detalle, baja) VALUES(?,?,?,?,?)";
        
        try {
          PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          ps.setString(1, comida.getNombre());
          ps.setString(2, comida.getTipoComida());
          ps.setInt(3, comida.getCaloriasPor100g());
          ps.setString(4, comida.getDetalle());
          ps.setBoolean(5, comida.isBaja());
          
           ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setConComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida añadida con éxito");
            }
            ps.close();
          
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar comida");
            
            
        }
    
    }
    
    
     public void guardarComidaid(Comida comida){
     
        String sql = "INSERT INTO comida (codComida, nombre, tipoComida, caloriasPor100g, detalle, baja) VALUES(?,?,?,?,?,?)";
        
        try {
          PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1, comida.getConComida());
          ps.setString(2, comida.getNombre());
          ps.setString(3, comida.getTipoComida());
          ps.setInt(4, comida.getCaloriasPor100g());
          ps.setString(5, comida.getDetalle());
          ps.setBoolean(6, comida.isBaja());
          
           ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setConComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida añadida con éxito");
            }
            ps.close();
          
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar comida");
            
            
        }
    
    }
    
    public ArrayList<Comida> listarComidas(){
    ArrayList<Comida> listComidas = new ArrayList<>();
    String sql = "SELECT * FROM comida";
    try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comida comida = new Comida();
                comida.setDetalle(rs.getString("detalle"));
                comida.setNombre(rs.getString("nombre"));
                comida.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                comida.setBaja(rs.getBoolean("baja"));
                comida.setTipoComida(rs.getString("tipoComida"));
                comida.setConComida(rs.getInt("codComida"));
               listComidas.add(comida);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al mostrar la lista");

        }
    
    
        return listComidas;
    
    }
    
    
    
    
    
    public Comida buscarComida(int id){
    Comida comida = new Comida();
        String sql = "SELECT * FROM comida WHERE codComida=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                comida.setConComida(id);
                comida.setDetalle(rs.getString("detalle"));
                comida.setCaloriasPor100g(rs.getInt("caloriasPor100g"));
                comida.setBaja(rs.getBoolean("baja"));
                comida.setNombre(rs.getString("nombre"));
                comida.setTipoComida(rs.getString("tipoComida"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro comida");
            }

            ps.close();
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al buscar comida");
        }

        return comida;
    
    
    
    
    
    }
    
    public void borrarComida(int id) {
    String sql = "UPDATE comida SET baja=0 WHERE codComida=?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        int x = ps.executeUpdate();
        
        if (x == 1) {
            JOptionPane.showMessageDialog(null, "Comida eliminada");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontro la comida ");
        }
        
        ps.close();
    } catch (SQLException ex) {
       
        JOptionPane.showMessageDialog(null, "Error al intentar eliminar la comida" + ex.getMessage());
    }
}
    
    
    
    
    
}

