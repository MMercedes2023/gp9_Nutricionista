package nutricionista_persistencia;

/**
 *
 * @author ACER
 */
import java.sql.*;
import gp9_nutricionista.modelo.Comida;
import gp9_nutricionista.modelo.RenglonDeMenu;
import javax.swing.JOptionPane;

public class RenglonDeMenuData {

    private Connection con = null;
    private ComidaData cD = new ComidaData();

    public RenglonDeMenuData() {
        con = Conexion.getConexion();
    }

    public RenglonDeMenu buscarRenglon(int id) {

        RenglonDeMenu rdm = new RenglonDeMenu();
        try {

            String sql = "SELECT * FROM renglondemenu WHERE nroRenglon=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rdm.setNroRenglon(id);
                rdm.setAlimento(cD.buscarComida(rs.getInt("alimento")));
                rdm.setCantidadGrs(rs.getDouble("cantidadGrs"));
                rdm.setSubtotalCalorias(rs.getInt("subtotalCalorias"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro ");
            }

            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error");

        }

        return rdm;
    }

    public void insertarRenglon(RenglonDeMenu rdm) {
        String sql = "INSERT INTO renglondemenu (codComida, cantidadGrs, subtotalCalorias) VALUES (?, ?, ?)";
//        calcularSubtotalCalorias();
        Comida c = rdm.getAlimento();
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, c.getConComida());
            ps.setDouble(2, rdm.getCantidadGrs());
            ps.setInt(3, rdm.getSubtotalCalorias());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                rdm.setNroRenglon(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Renglon  añadido con éxito");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar renglon: " + e.getMessage());
        }
    }

    public void actualizarRenglon(RenglonDeMenu rdm, int id) {
        String sql = "UPDATE renglondemenu SET codComida = ?, cantidadGrs = ?, subtotalCalorias = ? WHERE nroRenglon = ? AND codMenu = ?";
        Comida c = rdm.getAlimento();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getConComida());
            ps.setDouble(2, rdm.getCantidadGrs());
            ps.setInt(3, rdm.getSubtotalCalorias());
            ps.setInt(4, rdm.getNroRenglon());
            ps.setInt(5, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Se actualizó el renglón con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el renglón para actualizar.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar renglón: " + e.getMessage());
        }
    }

    public void eliminarRenglon(int id) {
        String sql = "DELETE FROM RenglonDeMenu WHERE nroRenglon = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            JOptionPane.showMessageDialog(null, "Se elimino el renglon");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el renglon: " + e.getMessage());
        }
    }

//    private void calcularSubtotalCalorias() {
//        double x = (c.getCaloriasPor100g() * rdm.getCantidadGrs()) / 100;
//        rdm.setSubtotalCalorias((int) x);
//    }
}
