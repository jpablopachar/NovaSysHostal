package Logica;

import Clases.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
    Author: Juan Pablo Pachar.
    Fecha: 7 de julio del 2017
    Modulo: Permite consultar, insertar, editar, eliminar un cliente
*/

public class LogicaCliente {
    private String sSQL = ""; // Almacena el codigo SQL
    
    LogicaConexion logicaConexion = new LogicaConexion();
    
    // Muestra los registros de la BD de la tabla Cliente
    public ResultSet consultar(String buscar) {
        
        try {
            // Crea un puente entre la conexión
            Statement st = logicaConexion.abrirConexion().createStatement();
            
            // Selecciona los registros de la tabla Cliente y filtra por
            // idCliente según el parámetro a buscar de forma descendente
            sSQL = "SELECT * FROM Cliente WHERE numDocumento LIKE '%" + buscar +
               "%' ORDER BY idCliente DESC";
            
            ResultSet rs = st.executeQuery(sSQL); // Guarda la instrucción SQL
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }
    }
    
    // Inserta un registro en la tabla Cliente
    // Recibe por parámetro la clase Cliente
    public boolean insertar(Cliente cliente) {
        // Instrucción SQL que inserta un registro en la tabla Cliente
        sSQL = "insert into Cliente (nombre, apellidoPaterno, apellidoMaterno, " +
               "tipoDocumento, numDocumento, direccion, telefono, email, " +
               "codigoCliente) " +
               "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envía uno a uno los valores a la instrucción SQL
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidoPaterno());
            pst.setString(3, cliente.getApellidoMaterno());
            pst.setString(4, cliente.getTipoDocumento());
            pst.setString(5, cliente.getNumDocumento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());
            pst.setString(9, cliente.getCodigoCliente());
            
            // Almacena el resultado de ejecución de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la inserción de registros en la tabla Cliente
            if (n != 0) {
                return true; // Se ha insertado en el registro
            } else {
                return false; // No se ha insertado el registro
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return false;
        }
    }
    
    // Edita un registro en la tabla Cliente
    public boolean editar(Cliente cliente) {
        // Modifica la tabla Cliente enviando una variable
        sSQL = "update Cliente set nombre=?, apellidoPaterno=?, " +
               "apellidoMaterno=?, tipoDocumento=?, numDocumento=?, " +
               "direccion=?, telefono=?, email=?, codigoCliente=? " +
               "where idCliente=?";
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envía uno a uno los valores a la instrucción SQL
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidoPaterno());
            pst.setString(3, cliente.getApellidoMaterno());
            pst.setString(4, cliente.getTipoDocumento());
            pst.setString(5, cliente.getNumDocumento());
            pst.setString(6, cliente.getDireccion());
            pst.setString(7, cliente.getTelefono());
            pst.setString(8, cliente.getEmail());
            pst.setString(9, cliente.getCodigoCliente());
            pst.setInt(10, cliente.getIdCliente());
            
            // Almacena el resultado de ejecución de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la inserción de registros en la tabla Cliente
            if (n != 0) {
                return true; // Se ha modificado el registro
            } else {
                return false; // No se ha modificado el registro
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return false;
        }
    }
    
    // Elimina un registro en la tabla Cliente
    public boolean eliminar(Cliente cliente) {
        // Elimina de la tabla Empleado un registro donde sea igual a idEmpleado
        sSQL = "delete from Cliente where idCliente=?";
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envía uno a uno los valores a la instrucción SQL
            pst.setInt(1, cliente.getIdCliente());
            
            // Almacena el resultado de ejecución de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la eliminación de registros en la tabla Cliente
            if (n != 0) {
                return true; // Se ha eliminado el registro
            } else {
                return false; // No se ha eliminado el registro
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return false;
        }
    }
}