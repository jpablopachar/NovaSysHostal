package Logica;

import Clases.Pago;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
    Author: Juan Pablo Pachar.
    Fecha: 22 de julio del 2017
    Modulo: Permite consultar, insertar, editar, eliminar un pago
*/

public class LogicaPago {
    private String sSQL = ""; // Variable que almacena la cadena de conexión SQL
    
    LogicaConexion logicaConexion = new LogicaConexion();
    
    // Muestra los registros de la base de datos de la tabla Pago
    public ResultSet consultar(String buscar) {
        try {
            // Crea un puente entre la conexión
            Statement st = logicaConexion.abrirConexion().createStatement();
            // Selecciona todos los registros de la tabla Pago y filtra por idReserva segun el parametro a buscar
            // de forma descendente
            sSQL = "select * from Pago where idReserva=" + buscar + " order by idPago desc";
            ResultSet rs = st.executeQuery(sSQL); // Ejecuta la instrucción SQL
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }
    }
    
    // Inserta un registro en la tabla Pago
    public boolean insertar(Pago pago) { // Recibe por parametro toda la clase Pago
        sSQL = "insert into Pago (idReserva,tipoComprobante,numComprobante,iva,totalPago,fechaEmision,fechaPago) "
             + "values (?,?,?,?,?,?,?)"; // Instrucción SQL que inserta registros en la tabla Pago
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, pago.getIdPago());
            pst.setString(2, pago.getTipoComprobante());
            pst.setString(3, pago.getNumComprobante());
            pst.setDouble(4, pago.getIva());
            pst.setDouble(5, pago.getTotalPago());
            pst.setDate(6, pago.getFechaEmision());
            pst.setDate(7, pago.getFechaPago());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la insercion de registros en la tabla Pago
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
    
    // Edita un registro en la tabla Pago
    public boolean editar(Pago pago) {
        // Modifica la tabla Pago enviando una variable
        sSQL = "update Pago set idReserva=?,tipoComprobante=?,numComprobante=?,iva=?,totalPago=?,fechaEmision=?,fechaPago=?" +
               " where idPago=?";
        
        try {
            // Contiene la cadena SQL para editar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, pago.getIdReserva());
            pst.setString(2, pago.getTipoComprobante());
            pst.setString(3, pago.getNumComprobante());
            pst.setDouble(4, pago.getIva());
            pst.setDouble(5, pago.getTotalPago());
            pst.setDate(6, pago.getFechaEmision());
            pst.setDate(7, pago.getFechaPago());
            pst.setInt(8, pago.getIdPago());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la edición de registros en la tabla Pago
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
    
    // Elimina un registro en la tabla Pago
    public boolean eliminar(Pago pago) {
        sSQL = "delete from Pago where idPago=?";
        
        try {
            // Contiene la cadena SQL para eliminar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, pago.getIdPago());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la eliminación de registros en la tabla Pago
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
