package Database;

import Logica.LogicaConsumo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 22 de julio del 2017
    Modulo: Clase que permite conexión hacia la base de datos
*/

public class DBConsumo {
    LogicaConsumo logicaConsumo = new LogicaConsumo();
    
    public int totalRegistros; // Variable que cuenta el total de registros
    public double totalConsumo; // Variable que almacena el consumo total
    
    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        
        ResultSet rs = logicaConsumo.consultar(buscar); // Recupera datos desde rs y los descompone
        // Vector que guarda una referencia de los titulos de la columna
        String[] titulos = {"Id", "Nombre servicio", "Cantidad", "Descripción",
            "Características", "Precio", "Estado"};
        // Vector que almacena los registros de cada titulo
        String[] registro = new String[7];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos); // Se agrega los titulos
        
        try {          
            // Navegación por todos los registros recorriendo de uno a uno
            while (rs.next()) {
                // Almacena todos los registros obtenidos por la variable rs de
                // la tabla Servicio 
                registro[0] = rs.getString("idConsumo");
                registro[1] = rs.getString("idReserva");
                registro[2] = rs.getString("idServicio");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("cantidad");
                registro[5] = rs.getString("precioVenta");
                registro[6] = rs.getString("estado");
                
                // Aumenta el total de registros en 1
                totalRegistros = totalRegistros + 1;
                // Acumula el totalConsumo dado la cantidad y el precio de venta
                totalConsumo = totalConsumo + (rs.getDouble("cantidad") * rs.getDouble("precioVenta"));
                
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
