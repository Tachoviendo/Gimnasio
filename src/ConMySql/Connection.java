
package ConMySql;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Connection {
    private static final String db = "gymbro";
    private static final String user ="root";
    private static final String pass ="";
    private static final String url="jdbc:mysql://localhost:3306/"+db;
    private static java.sql.Connection con;
    
    public static java.sql.Connection getConection(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        }catch(ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null,"Conexión no establecida: "+ e);
        }
        return con;
    }
    public void cerrarBD() throws SQLException{
        if(!con.isClosed())
            con.close();
    }
    
}
