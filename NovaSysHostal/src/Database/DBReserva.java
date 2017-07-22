package Database;

import Logica.LogicaReserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 21 de julio del 2017
    Modulo: Clase que permite conexión hacia la base de datos
*/

public class DBReserva {
    LogicaReserva logicaReserva = new LogicaReserva();
    
    public int totalRegistros; // Variable que cuenta el total de registros
    
    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        
        ResultSet rs = logicaReserva.consultar(buscar); // Recupera datos desde rs y los descompone
        // Vector que guarda una referencia de los titulos de la columna
        String[] titulos = {"Id Reserva", "Id Cliente", "Nombre cliente",
                            "Id Empleado", "Nombre empleado", "Tipo de reserva",
                            "Fecha de reserva", "Fecha de ingreso", "Fecha de salida",
                            "Costo", "Estado"};
        // Vector que almacena los registros de cada titulo
        String[] registro = new String[11];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos); // Se agrega los titulos
        
        try {          
            // Navegación por todos los registros recorriendo de uno a uno
            while (rs.next()) {
                // Se almacenan los registros obtenidos por la variable rs
                // de la tabla Reserva
                registro[0] = rs.getString("idReserva");
                registro[1] = rs.getString("idCliente");
                registro[2] = rs.getString("nombreCliente") + " " + rs.getString("clienteApellidoP");
                registro[3] = rs.getString("idEmpleado");
                registro[4] = rs.getString("nombreEmpleado") + " " + rs.getString("apellidoEmpleado");
                registro[5] = rs.getString("tipoReserva");
                registro[6] = rs.getString("fechaReserva");
                registro[7] = rs.getString("fechaIngreso");
                registro[8] = rs.getString("fechaSalida");
                registro[9] = rs.getString("costoAlojamiento");
                registro[10] = rs.getString("estado");
                
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
