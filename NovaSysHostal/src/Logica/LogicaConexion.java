package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
    Author: Juan Pablo Pachar.
    Fecha: 28 de junio del 2017
    Modulo: Clase para la conexión hacia la base de datos
 */

public class LogicaConexion {
    public static Connection link;
    
    // Metodo que nos ayuda a conectarse a la base de datos
    public Connection getConnection() {
        String db = "NovaSysHostal"; // Nombre de la base de datos
        String url = "jdbc:mysql://127.0.0.1/" + db; // Cadena de conexión
        String user = "root"; // Nombre de usuario de mi gestor de bd
        String pass = "jppachar"; // Contraseña de mi gestor de bd
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); // Cargar el driver de conexión
        
            // Se crea un enlace hacia la base de datos
            link = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            // Muestra un mensaje sobre el posible error que aparezca
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;
    }
    
    // Metodo para abrir la conexion
    public Connection abrirConexion() throws SQLException {
        link = getConnection();
        
        // Devuelve la cadena de conexión
        return link;
    }
    
    // Metodo para cerra la conexion
    public void cerrarConexion() throws SQLException {
        link.close();    
    }
}