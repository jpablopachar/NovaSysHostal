package Database;

import Logica.LogicaCliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 20 de julio del 2017
    Modulo: Clase que permite conexión hacia la base de datos
*/

public class DBCliente {
    LogicaCliente logicaCliente = new LogicaCliente();
    
    public int totalRegistros; // Variable que cuenta el total de registros
    
    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        
        ResultSet rs = logicaCliente.consultar(buscar); // Recupera datos desde rs y los descompone
        // Vector que guarda una referencia de los titulos de la columna
        String[] titulos = {"id", "Nombre", "Apellido paterno",
            "Apellido materno", "Tipo de documento", "Número de documento",
            "Dirección", "Teléfono", "Email", "Código del cliente"};
        // Vector que almacena los registros de cada titulo
        String[] registro = new String[10];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos); // Se agrega los titulos
        
        try {          
            // Navegación por todos los registros recorriendo de uno a uno
            while (rs.next()) {
                // Almacena todos los registros obtenidos por la variable rs de
                // la tabla Cliente
                registro[0] = rs.getString("idCliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("tipoDocumento");
                registro[5] = rs.getString("numDocumento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("codigoCliente");
                
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
}
