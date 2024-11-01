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
    private ComidaData cD = new ComidaData();
    Comida c = new Comida();

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

    

    public void modificarAlimento() {
        String sql = "UPDATE comida SET nombre = ?, caloriasPor100g = ?, tipoComida = ?, detalle = ? WHERE codComida = ?";
       
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getNombre());
            ps.setInt(2, c.getCaloriasPor100g());
            ps.setString(3, c.getTipoComida());
            ps.setString(4, c.getDetalle());
            ps.setInt(5, c.getConComida());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "El alimento se ha sido modificada éxitosamente ");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder al alimento:  " + ex.getMessage());
        }
    }
}

