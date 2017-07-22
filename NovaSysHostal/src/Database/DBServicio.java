package Database;

import Logica.LogicaServicio;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 20 de julio del 2017
    Modulo: Clase que permite conexión hacia la base de datos
*/

public class DBServicio {
    LogicaServicio logicaServicio = new LogicaServicio();
    
    public int totalRegistros; // Variable que cuenta el total de registros
    
    public DefaultTableModel consultar(String buscar) {
        DefaultTableModel modelo;
        
        ResultSet rs = logicaServicio.consultar(buscar); // Recupera datos desde rs y los descompone
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
                registro[0] = rs.getString("idServicio");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("cantidad");
                registro[3] = rs.getString("descripcion");
                registro[4] = rs.getString("caracteristicas");
                registro[5] = rs.getString("precio");
                registro[6] = rs.getString("estado");
                
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