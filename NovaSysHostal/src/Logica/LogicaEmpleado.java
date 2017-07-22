package Logica;

import Clases.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
    Author: Juan Pablo Pachar.
    Fecha: 3 de julio del 2017
    Modulo: Permite consultar, insertar, editar, eliminar un empleado
*/

public class LogicaEmpleado {
    private String sSQL = ""; // Almacena el codigo SQL
    
    LogicaConexion logicaConexion = new LogicaConexion();
    
    // Muestra los registros de la BD de la tabla Empleado
    public ResultSet consultar(String buscar) {
        try {
            // Crea un puente entre la conexión
            Statement st = logicaConexion.abrirConexion().createStatement();
            
            // Selecciona los registros de la tabla Empleado y filtra por
            // numDocumento según el parámetro a buscar de forma descendente
            sSQL = "select * from Empleado where numDocumento like '%" + buscar +
                   "%' order by idEmpleado desc";
            
            ResultSet rs = st.executeQuery(sSQL); // Ejecuta la instrucción SQL
            
            return rs;
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }
    }
    
    // Inserta un registro en la tabla Empleado
    // Recibe por parámetro la clase Empleado
    public boolean insertar(Empleado empleado) {
        // Instrucción SQL que inserta un registro en la tabla Empleado
        sSQL = "insert into Empleado (nombre, apellidoPaterno, apellidoMaterno, " +
               "tipoDocumento, numDocumento, direccion, telefono, email, " +
               "sueldo, acceso, login, password, estado) " +
               "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            // Contiene la cadena SQL para insertar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envía uno a uno los valores a la instrucción SQL
            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getApellidoPaterno());
            pst.setString(3, empleado.getApellidoMaterno());
            pst.setString(4, empleado.getTipoDocumento());
            pst.setString(5, empleado.getNumDocumento());
            pst.setString(6, empleado.getDireccion());
            pst.setString(7, empleado.getTelefono());
            pst.setString(8, empleado.getEmail());
            pst.setDouble(9, empleado.getSueldo());
            pst.setString(10, empleado.getAcceso());
            pst.setString(11, empleado.getLogin());
            pst.setString(12, empleado.getPassword());
            pst.setString(13, empleado.getEstado());
            
            // Almacena el resultado de ejecución de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la inserción de registros en la tabla Empleado
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
    
    // Edita un registro en la tabla Empleado
    public boolean editar(Empleado empleado) {
        // Modifica la tabla Empelado enviando una variable
        sSQL = "update Empleado set nombre=?, apellidoPaterno=?, " +
               "apellidoMaterno=?, tipoDocumento=?, numDocumento=?, " +
               "direccion=?, telefono=?, email=?, sueldo=?, " +
               "acceso=?, login=?, password=?, estado=? where idEmpleado=?";
        
        try {
            // Contiene la cadena SQL para modificar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envía uno a uno los valores a la instrucción SQL
            pst.setString(1, empleado.getNombre());
            pst.setString(2, empleado.getApellidoPaterno());
            pst.setString(3, empleado.getApellidoMaterno());
            pst.setString(4, empleado.getTipoDocumento());
            pst.setString(5, empleado.getNumDocumento());
            pst.setString(6, empleado.getDireccion());
            pst.setString(7, empleado.getTelefono());
            pst.setString(8, empleado.getEmail());
            pst.setDouble(9, empleado.getSueldo());
            pst.setString(10, empleado.getAcceso());
            pst.setString(11, empleado.getLogin());
            pst.setString(12, empleado.getPassword());
            pst.setString(13, empleado.getEstado());
            pst.setInt(14, empleado.getIdEmpleado());
            
            // Almacena el resultado de ejecución de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la inserción de registros en la tabla Empleado
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
    
    // Elimina un registro en la tabla Empleado
    public boolean eliminar(Empleado empleado) {
        // Elimina de la tabla Empleado un registro donde sea igual a idEmpleado
        sSQL = "delete from Empleado where idEmpleado=?";
        
        try {
            // Contiene la cadena SQL para modificar un registro
            PreparedStatement pst = logicaConexion.abrirConexion().prepareStatement(sSQL);
            
            // Envía uno a uno los valores a la instrucción SQL
            pst.setInt(1, empleado.getIdEmpleado());
            
            // Almacena el resultado de ejecución de la cadena SQL
            int n = pst.executeUpdate();
            
            // Se cumple o no la eliminación de registros en la tabla Empleado
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
    
    // Valida el ingreso del Empleado segun el cargo que ocupe
    public ResultSet login(String login, String password) {
        try {
            // Crea un puente entre la conexión
            Statement st = logicaConexion.abrirConexion().createStatement();
            // Selecciona todos los registros de la tabla Trabajador y filtra por login y password
            sSQL = "SELECT idEmpleado, nombre, apellidoPaterno, apellidoMaterno, acceso, login, password, estado "
                 + "FROM Empleado WHERE login = '" + login + "' AND password = '" + password + "' AND estado = 'Activo'";
            
            ResultSet rs = st.executeQuery(sSQL); // Ejecuta la instrucción SQL
            
            return rs; 
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e); // Muestra el error
            return null;
        }
    }
}