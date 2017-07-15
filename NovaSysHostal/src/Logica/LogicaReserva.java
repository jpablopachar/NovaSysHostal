package Logica;

import Clases.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 7 de julio del 2017
    Modulo: Permite mostrar, insertar, editar, eliminar una reserva
*/

public class LogicaReserva {
    private Conexion mysql = new Conexion(); // Instancia de la clase conexión
    private Connection cn = mysql.conectar(); // Variable que llama a la función conectar 
    private String sSQL = ""; // Variable que almacena la cadena de conexión SQL
    public int totalRegistros; // Variable que cuenta el total de registros
    
    // Muestra los registros de la base de datos de la tabla Reserva
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        // Vector que guarda una referencia de los titulos de la columna
        String[] titulos = {"Id Reserva", "Id Cliente", "Nombre cliente",
                            "Id Empleado", "Nombre empleado", "Tipo de reserva",
                            "Fecha de reserva", "Fecha de ingreso", "Fecha de salida",
                            "Costo", "Estado"};
        // Vector que almacena los registros de cada titulo
        String[] registro = new String[11];
        totalRegistros = 0;
        modelo = new DefaultTableModel(null, titulos); // Se agrega los titulos
        // Selecciona todos los registros de la tabla Reserva y filtra por idReserva
        // segun el parametro a buscar de forma descendente
        sSQL = "SELECT r.idReserva, r.idCliente, " +
               "(SELECT nombre FROM Cliente WHERE idCliente = r.idCliente) AS nombreCliente, " +
               "(SELECT apellidoPaterno FROM Cliente WHERE idCliente = r.idCliente) AS clienteApellidoP, " +
               "r.idEmpleado, (SELECT nombre FROM Empleado WHERE idEmpleado = r.idEmpleado) AS nombreEmpleado," +
               "(SELECT apellidoPaterno FROM Empleado WHERE idEmpleado = r.idEmpleado) AS apellidoEmpleado, " +
               "r.tipoReserva, r.fechaReserva, r.fechaIngreso, r.fechaSalida, r.costoAlojamiento, r.estado " +
               "FROM Reserva r WHERE r.fechaReserva LIKE '%" + buscar + "%' ORDER BY idReserva DESC";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); // Ejecuta la instrucción SQL
            
            // Navegación por todos los registros recorriendo de uno a uno
            while (rs.next()) {
                // Almacena todos los registros obtenidos por la variable rs de la tabla Reserva 
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
                
                totalRegistros = totalRegistros + 1; // Aumenta el total de registros en 1
                
                modelo.addRow(registro); // Agrega a la variable modelo a manera de fila, todo el registro
            }
            
            return modelo;
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
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
    
    /*// Edita un registro en la tabla Reserva
    public boolean pagar(Reserva reserva) {
        // Modifica el estado de la reserva a Pagada
        sSQL = "update Reserva set estado='Pagada' where idReserva=?";
        
        try {
            // Contiene la cadena SQL para editar un registro
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
    }*/
}
