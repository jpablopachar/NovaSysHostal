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

public class Conexion {
    public String db = "NovaSysHostal"; // Nombre de la base de datos
    public String url = "jdbc:mysql://127.0.0.1/" + db; // Cadena de conexión
    public String user = "root"; // Nombre de usuario de mi gestor de bd
    public String pass = "jppachar"; // Contraseña de mi gestor de bd

    public Conexion() {
    }
    
    // Metodo que nos ayuda a conectarse a la base de datos
    public Connection conectar() {
        Connection link = null; // Variable que instancia a la clase Connection
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver"); // Cargar el driver de conexión
            // Se crea un enlace hacia la base de datos
            link = DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            // Muestra un mensaje sobre el posible error que aparezca
            JOptionPane.showConfirmDialog(null, e);
        }
        
        // Devuelve la cadena de conexión
        return link;
    }
}