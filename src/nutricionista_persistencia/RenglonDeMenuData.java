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
    private RenglonDeMenuData rDMD = new RenglonDeMenuData();
    RenglonDeMenu rdm = new RenglonDeMenu();
    Comida c = new Comida();

    public RenglonDeMenuData() {
        con = Conexion.getConexion();
    }

    public void insertarRenglon() {
        String sql = "INSERT INTO renglondemenu (nroRenglon, codComida, cantidadGrs, subtotalCalorias) VALUES (?, ?, ?, ?, ?)";
        calcularSubtotalCalorias();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rdm.getNroRenglon());
            ps.setInt(2, c.getConComida());
            ps.setDouble(4, rdm.getCantidadGrs());
            ps.setInt(5, rdm.getSubtotalCalorias());
            JOptionPane.showMessageDialog(null, "Se ingreso el renglon");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar renglon: " + e.getMessage());
        }
    }

    public void actualizarRenglon() {
        String sql = "UPDATE renglondemenu SET codComida = ?, cantidadGrs = ?, subtotalCalorias = ? WHERE nroRenglon = ? AND codMenu = ?";
        calcularSubtotalCalorias();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, c.getConComida());
            ps.setDouble(2, rdm.getCantidadGrs());
            ps.setInt(3, rdm.getSubtotalCalorias());
            ps.setInt(4, rdm.getNroRenglon());
            JOptionPane.showMessageDialog(null, "Se actualizo el renglon");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar renglon: " + e.getMessage());
        }
    }

    public void eliminarRenglon() {
        String sql = "DELETE FROM RenglonDeMenu WHERE nroRenglon = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rdm.getNroRenglon());
            JOptionPane.showMessageDialog(null, "Se elimino el renglon");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el renglon: " + e.getMessage());
        }
    }

    private void calcularSubtotalCalorias() {
        double x = (c.getCaloriasPor100g() * rdm.getCantidadGrs()) / 100;
        rdm.setSubtotalCalorias((int) x);
    }
}
