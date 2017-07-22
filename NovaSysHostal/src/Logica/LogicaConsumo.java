package Logica;

import Clases.Consumo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
    Author: Juan Pablo Pachar.
    Fecha: 22 de julio del 2017
    Modulo: Permite consultar, insertar, editar, eliminar un consumo
*/
public class LogicaConsumo {
    private String sSQL = ""; // Almacena el codigo SQL
    
    LogicaConexion logicaConexion = new LogicaConexion();
    
    // Muestra los registros de la BD de la tabla Cliente
    public ResultSet consultar(String buscar) {
        
        try {
            // Crea un puente entre la conexión
            Statement st = logicaConexion.abrirConexion().createStatement();
            
            // Selecciona todos los registros de la tabla Consumo y filtra por idConsumo segun el parametro a buscar
            // de forma descendente
            sSQL = "SELECT c.idConsumo, c.idReserva, c.Servicio, s.nombre, c.cantidad, c.precioVenta, c.estado"
             + " FROM Consumo c INNER JOIN Servicio s ON c.idProducto = s.idProducto"
             + " WHERE c.idReserva = " + buscar + " ORDER BY idConsumo DESC";
            
            ResultSet rs = st.executeQuery(sSQL); // Guarda la instrucción SQL
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }
    }
    
    // Inserta un registro en la tabla Consumo
    public boolean insertar(Consumo consumo) { // Recibe por parametro toda la clase Consumo
        sSQL = "insert into Consumo (idReserva,idServicio,cantidad,precioVenta,estado) "
             + "values (?,?,?,?,?)"; // Instrucción SQL que inserta registros en la tabla Consumo
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, consumo.getIdReserva());
            pst.setInt(2, consumo.getIdServicio());
            pst.setDouble(3, consumo.getCantidad());
            pst.setDouble(4, consumo.getPrecioVenta());
            pst.setString(5, consumo.getEstado());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la insercion de registros en la tabla Consumo
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
    
    // Edita un registro en la tabla Consumo
    public boolean editar(Consumo consumo) {
        // Modifica de la tabla Consumo enviando una variable
        sSQL = "update Consumo set idReserva=?,idServicio=?,cantidad=?,precioVenta=?,estado=?" +
               " where idConsumo=?";
        
        try {
            // Contiene la cadena SQL para editar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, consumo.getIdReserva());
            pst.setInt(2, consumo.getIdServicio());
            pst.setDouble(3, consumo.getCantidad());
            pst.setDouble(4, consumo.getPrecioVenta());
            pst.setString(5, consumo.getEstado());
            pst.setInt(6, consumo.getIdConsumo());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la edición de registros en la tabla Consumo
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
    
    // Elimina un registro en la tabla Consumo
    public boolean eliminar(Consumo consumo) {
        sSQL = "delete from Consumo where idConsumo=?";
        
        try {
            // Contiene la cadena SQL para eliminar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, consumo.getIdConsumo());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la eliminación de registros en la tabla Consumo
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
