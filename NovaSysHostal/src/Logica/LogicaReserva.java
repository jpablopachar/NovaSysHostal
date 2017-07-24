package Logica;

import Clases.Reserva;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
    Author: Juan Pablo Pachar.
    Fecha: 15 de julio del 2017
    Modulo: Permite consultar, insertar, editar, eliminar una reserva
*/

public class LogicaReserva {
    private String sSQL = ""; // Almacena el codigo SQL
    
    LogicaConexion logicaConexion = new LogicaConexion();
    
    // Muestra los registros de la base de datos de la tabla Reserva
    public ResultSet consultar(String buscar) {
        try {
            // Crea un puente entre la conexión
            Statement st = logicaConexion.abrirConexion().createStatement();
            
            // Selecciona todos los registros de la tabla Reserva y filtra por idReserva
            // segun el parametro a buscar de forma descendente
            sSQL = "SELECT r.idReserva, r.idCliente, " +
                   "(SELECT nombre FROM Cliente WHERE idCliente = r.idCliente) AS nombreCliente, " +
                   "(SELECT apellidoPaterno FROM Cliente WHERE idCliente = r.idCliente) AS clienteApellidoP, " +
                   "r.idEmpleado, (SELECT nombre FROM Empleado WHERE idEmpleado = r.idEmpleado) AS nombreEmpleado, " +
                   "(SELECT apellidoPaterno FROM Empleado WHERE idEmpleado = r.idEmpleado) AS apellidoEmpleado, " +
                   "r.tipoReserva, r.fechaReserva, r.fechaIngreso, r.fechaSalida, r.costoAlojamiento, r.estado " +
                   "FROM Reserva r WHERE r.fechaReserva LIKE '%" + buscar + "%' ORDER BY idReserva DESC";
            
            ResultSet rs = st.executeQuery(sSQL); // Ejecuta la instrucción SQL
            
            return rs;    
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }
    }
    
    // Inserta un registro en la tabla Reserva
    public boolean insertar(Reserva reserva) { // Recibe por parametro toda la clase Reserva
        // Instrucción SQL que inserta registros en la tabla Reserva
        sSQL = "INSERT INTO Reserva (idCliente, idEmpleado, tipoReserva, fechaReserva, " +
               "fechaIngreso, fechaSalida, costoAlojamiento, estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, reserva.getIdCliente());
            pst.setInt(2, reserva.getIdEmpleado());
            pst.setString(3, reserva.getTipoReserva());
            pst.setDate(4, reserva.getFechaReserva());
            pst.setDate(5, reserva.getFechaIngreso());
            pst.setDate(6, reserva.getFechaSalida());
            pst.setDouble(7, reserva.getCostoAlojamiento());
            pst.setString(8, reserva.getEstado());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la insercion de registros en la tabla Reserva
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
    
    // Edita un registro en la tabla Reserva
    public boolean editar(Reserva reserva) {
        // Modifica de la tabla Producto enviando una variable
        sSQL = "UPDATE Reserva set idCliente = ?, idEmpleado = ?, tipoReserva = ?, " +
               "fechaReserva = ?, fechaIngreso = ?, fechaSalida = ?, " +
               "costoAlojamiento = ?, estado = ? WHERE idReserva = ?";
        
        try {
            // Contiene la cadena SQL para editar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, reserva.getIdCliente());
            pst.setInt(2, reserva.getIdEmpleado());
            pst.setString(3, reserva.getTipoReserva());
            pst.setDate(4, reserva.getFechaReserva());
            pst.setDate(5, reserva.getFechaIngreso());
            pst.setDate(6, reserva.getFechaSalida());
            pst.setDouble(7, reserva.getCostoAlojamiento());
            pst.setString(8, reserva.getEstado());
            pst.setInt(9, reserva.getIdReserva());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la edición de registros en la tabla Reserva
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
    
    // Elimina un registro en la tabla Reserva
    public boolean eliminar(Reserva reserva) {
        sSQL = "DELETE FROM Reserva WHERE idReserva = ?";
        
        try {
            // Contiene la cadena SQL para eliminar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, reserva.getIdReserva());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la eliminación de registros en la tabla Reserva
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
    
    // Edita un registro en la tabla Reserva
    public boolean pagar(Reserva reserva) {
        // Modifica el estado de la reserva a Pagada
        sSQL = "update Reserva set estado='Pagada' where idReserva=?";
        
        try {
            // Contiene la cadena SQL para editar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envia uno a uno todos los valores a la instrucción SQL
            pst.setInt(1, reserva.getIdReserva());
            
            int n = pst.executeUpdate(); // Almacena el resultado de la ejecucion de la cadena SQL
            
            // Se cumple o no la edición de registros en la tabla Reserva
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
}
