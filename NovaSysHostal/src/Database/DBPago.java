package Database;

import Logica.LogicaPago;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 22 de julio del 2017
    Modulo: Clase que permite conexión hacia la base de datos
*/

public class DBPago {
    LogicaPago logicaPago = new LogicaPago();
    
    public int totalRegistros; // Variable que cuenta el total de registros
    
    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        
        ResultSet rs = logicaPago.consultar(buscar); // Recupera datos desde rs y los descompone
        // Vector que guarda una referencia de los titulos de la columna
        String[] titulos = {"idPago", "idReserva", "Tipo de comprobante", "Numero de comprobante",
                            "IVA", "Pago total", "Fecha de emisión", "Fecha de pago"};
        // Vector que almacena los registros de cada titulo
        String[] registro = new String[8];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos); // Se agrega los titulos
        
        try {          
            // Navegación por todos los registros recorriendo de uno a uno
            while (rs.next()) {
                // Almacena todos los registros obtenidos por la variable rs de
                // la tabla Servicio 
                registro[0] = rs.getString("idPago");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("tipoComprobante");
                registro[3] = rs.getString("numComprobante");
                registro[4] = rs.getString("iva");
                registro[5] = rs.getString("totalPago");
                registro[6] = rs.getString("fechaEmision");
                registro[7] = rs.getString("fechaPago");
                
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
