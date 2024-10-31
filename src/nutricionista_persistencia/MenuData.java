//package nutricionista_persistencia;
//
//import gp9_nutricionista.modelo.MenuDiario;
//import java.sql.Connection;
//import gp9_nutricionista.modelo.RenglonDeMenu;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import javax.swing.JOptionPane;
//import org.mariadb.jdbc.Statement;
//
//public class MenuData {
//    
//private Connection con= null;
//
//public MenuData(){
//
//    con= Conexion.getConexion();
//
//}
//
//public void guardarMenu (MenuDiario menuDiario ){
//    String sql= "INSERT INTO menudiario(diaNro,estado,coDieta) VALUES(?,?,?)";
//        try{
//        PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
//        ps.setInt(1,menuDiario.getDiaNro());
//        ps.setBoolean(2,menuDiario.isEstado());
//        ps.setInt(3, menuDiario.getDieta();
//        ps.executeUpdate();
//        ResultSet rs=ps.getGeneratedKeys();
//        if(rs.next()){
//        menuDiario.setCodMenu(rs.getInt("codMenu"));
//        JOptionPane.showMessageDialog(null," Menu guardado con éxito ");
//        }
//        
//        ps.close();
//        }catch(SQLException ex){
//        
//            JOptionPane.showMessageDialog(null,"Error al acceder al MenuDiario "+ ex.getMessage());
//        
//        }
//    
//    
//}
//public MenuDiario buscarMenuPorId(int codMenu){
// MenuDiario menu = null;
//        String sql = "SELECT diaNro,estado,codDieta FROM menuDiario WHERE codMenu =? AND estado=1";
//        PreparedStatement ps = null;
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, codMenu);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                menu=new MenuDiario();
//                menu.setCodMenu(rs.getInt("codMenu"));
//                menu.setDiaNro(rs.getInt("diaNro"));
//                menu.setEstado(true);
//                menu.setDieta(rs.getInt("codDieta"));
//                
//                }else{
//                JOptionPane.showMessageDialog(null, "No existe el Menu");
//        
//        }
//            ps.close();
//
//        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Error al acceder a  Menú " + ex.getMessage());
//        }
//        return menu;
//
//    }
//
//public void modificarMenu(MenuDiario menu){
//String sql="UPDATE menudiario SET diaNro=?,estado=?,codDieta=? WHERE codMenu=?";
//PreparedStatement ps=null;
//try{
//ps=con.prepareStatement(sql);
//ps.setInt(1,menu.getDiaNro() );
//
//int exito=ps.executeUpdate();
//if(exito==1){
//    JOptionPane.showMessageDialog(null,"Menú modificado éxitosamente");
//}else{
//    JOptionPane.showMessageDialog(null,"el Menu no exite");
//}   
//}catch(SQLException ex){
//
//JOptionPane.showMessageDialog(null,"Error al acceder al Menu"+ ex.getMessage());
//}
//
//
//}
//
//public void borrarMenu(int codMenu){
//try{
//String sql="UPDATE menudiario SET estado=0 WHERE codMenu=? ";
//PreparedStatement ps=con.prepareStatement(sql);
//ps.setInt(1, codMenu);
//int fila=ps.executeUpdate();
//if (fila==1){
//JOptionPane.showConfirmDialog(null, "Se eliminó el Menú");
//}
//ps.close();
//}catch(SQLException e){
//JOptionPane.showMessageDialog(null,"Error al acceder a Menu" +e.getMessage());}
//
//}
//}
