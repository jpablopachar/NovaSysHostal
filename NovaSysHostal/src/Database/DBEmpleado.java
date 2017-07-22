package Database;

import Logica.LogicaEmpleado;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 21 de julio del 2017
    Modulo: Clase que permite conexión hacia la base de datos
*/

public class DBEmpleado {
    LogicaEmpleado logicaEmpleado = new LogicaEmpleado();
    
    public int totalRegistros; // Variable que cuenta el total de registros
    
    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        
        ResultSet rs = logicaEmpleado.consultar(buscar); // Recupera datos desde rs y los descompone
        // Vector que guarda una referencia de los titulos de la columna
        String[] titulos = {"id", "Nombre", "Apellido paterno",
                "Apellido materno", "Tipo de documento", "Número de documento",
                "Dirección", "Teléfono", "Email", "Sueldo", "Acceso", "Login",
                "Password", "Estado"};
        // Vector que almacena los registros de cada titulo
        String[] registro = new String[14];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos); // Se agrega los titulos
        
        try {          
            // Navegación por todos los registros recorriendo de uno a uno
            while (rs.next()) {
                // Se almacenan los registros obtenidos por la variable rs
                // de la tabla Empleado
                registro[0] = rs.getString("idEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("tipoDocumento");
                registro[5] = rs.getString("numDocumento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");
                
                // Aumenta el total de registros en 1
                totalRegistros = totalRegistros + 1; 
                
                // Agrega a la variable modelo a manera de fila, todo el registro
                modelo.addRow(registro); 
            }
            
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }   
    }
    
    public DefaultTableModel login(String login, String password) {
        DefaultTableModel modelo;
            
        ResultSet rs = logicaEmpleado.login(login, password); // Recupera datos desde rs y los descompone
            
        // Vector que guarda una referencia de los titulos de la columna
        String[] titulos = {"Id", "Nombre", "Apellido Paterno", 
            "Apellido Materno", "Acceso", "Login", "Password", "Estado"};
        // Vector que almacena los registros de cada titulo
        String[] registro = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos); // Se agrega los titulos
        
        try {
            // Navegación por todos los registros recorriendo de uno a uno
            while (rs.next()) {
                // Almacena todos los registros obtenidos por la variable rs de la tabla Empleado
                registro[0] = rs.getString("idEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("acceso");
                registro[5] = rs.getString("login");
                registro[6] = rs.getString("password");
                registro[7] = rs.getString("estado");
                
                totalRegistros = totalRegistros + 1; // Aumenta el total de registros en 1
                
                modelo.addRow(registro); // Agrega a la variable modelo a manera de fila, todo el registro
            }
            
            return modelo;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }    
    }
}
