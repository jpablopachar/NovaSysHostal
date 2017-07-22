package Logica;

import Clases.Servicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
    Author: Juan Pablo Pachar.
    Fecha: 16 de julio del 2017
    Modulo: Permite consultar, insertar, editar, eliminar un Servicio
*/

public class LogicaServicio {
    private String sSQL = ""; // Variable que almacena la cadena de conexión SQL
    
    LogicaConexion logicaConexion = new LogicaConexion();
    
    // Muestra los registros de la base de datos de la tabla Producto
    public ResultSet consultar(String buscar) {
        try {
            // Crea un puente entre la conexión
            Statement st = logicaConexion.abrirConexion().createStatement();
            // Selecciona todos los registros de la tabla Servicio y filtra por nombre 
            sSQL = "SELECT * FROM Servicio WHERE nombre like '%" + buscar + "%' order by idServicio desc";
            ResultSet rs = st.executeQuery(sSQL); // Guarda la instrucción SQL

            return rs;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }   
    }
    
    // Inserta un registro en la tabla Servicio
    // Recibe por parametro toda la clase Servicio
    public boolean insertar(Servicio servicio) {
        // Instrucción SQL que inserta registros en la tabla Servicio
        sSQL = "INSERT INTO Servicio (nombre, cantidad, descripcion, " +
               "caracteristicas, precio, estado) VALUES (?, ?, ?, ?, ?, ?)";
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);

            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setString(1, servicio.getNombre());
            pst.setDouble(2, servicio.getCantidad());
            pst.setString(3, servicio.getDescripcion());
            pst.setString(4, servicio.getCaracteristicas());
            pst.setDouble(5, servicio.getPrecio());
            pst.setString(6, servicio.getEstado());
            
            // Almacena el resultado de la ejecucion de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la insercion de registros en la tabla Servicio
            if (n != 0) {
                return true; // Si se ha insertado registros
            } else {
                return false; // NO se han insertado registrados
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return false;
        }
    }
    
    
    // Edita un registro en la tabla Servicio
    public boolean editar(Servicio servicio) {
        // Modifica de la tabla Servicio enviando una variable
        sSQL = "UPDATE Servicio SET nombre = ?, cantidad = ?, descripcion = ?, " +
               "caracteristicas = ?, precio = ?, estado = ? WHERE idServicio = ?";
        
        try {
            // Contiene la cadena SQL para editar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setString(1, servicio.getNombre());
            pst.setDouble(2, servicio.getCantidad());
            pst.setString(3, servicio.getDescripcion());
            pst.setString(4, servicio.getCaracteristicas());
            pst.setDouble(5, servicio.getPrecio());
            pst.setString(6, servicio.getEstado());
            pst.setInt(7, servicio.getIdServicio());
            
            // Almacena el resultado de la ejecucion de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la edición de registros en la tabla Servicio
            if (n != 0) {
                return true; // Si se ha editado el registro
            } else {
                return false; // NO se ha editado el registro
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return false;
        }
    }
    
    // Elimina un registro en la tabla Servicio
    public boolean eliminar(Servicio servicio) {
        sSQL = "DELETE from Servicio WHERE idServicio = ?";
        
        try {
            // Contiene la cadena SQL para eliminar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, servicio.getIdServicio());
            
            // Almacena el resultado de la ejecucion de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la eliminación de registros en la tabla Servicio
            if (n != 0) {
                return true; // Si se ha eliminado el registro
            } else {
                return false; // No se ha eliminado el registro
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return false;
        }
    }
}