package mx.uv;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/ejemplo80640";
    private static String DriverName = "com.mysql.jdbc.Driver";
    private static String username = "root";
    private static String password = "";
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName(DriverName);
            connection = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("listo conectado");
        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("no encontro el driver");
        }
        return connection;
    }
}
