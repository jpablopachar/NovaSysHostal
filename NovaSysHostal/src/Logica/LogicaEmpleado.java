package Logica;

import Clases.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    Author: Juan Pablo Pachar.
    Fecha: 3 de julio del 2017
    Modulo: Permite mostrar, insertar, editar, eliminar un empleado
*/

public class LogicaEmpleado {
    private Conexion mysql = new Conexion(); // Instancia la clase Conexion
    private Connection cn = mysql.conectar(); // Llama a la función conectar
    private String sSQL = ""; // Almacena el codigo SQL
    public int totalRegistros; // Cuenta el total de registros
    
    // Muestra los regsitros de la BD de la tabla Empleado
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        // Arreglo que hace una referencia de los titulos de las columnas
        // de la tabla
        String[] titulos = {"id", "Nombre", "Apellido paterno",
            "Apellido materno", "Tipo de documento", "Número de documento",
            "Dirección", "Teléfono", "Email", "Sueldo", "Acceso", "Login",
            "Password", "Estado"};
        
        // Arreglo que almacena los registros de cada titulo
        String[] registro = new String[14];
        totalRegistros = 0;
        // Se agrega los titulos de la tabla
        modelo = new DefaultTableModel(null, titulos);
        
        // Selecciona los registros de la tabla Empleado y filtra por
        // idEmpleado según el parámetro a buscar de forma descendente
        sSQL = "select * from Empleado where numDocumento like '%" + buscar + "%' order by idEmpleado desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); // Ejecuta la instrucción SQL
            
            // Recorre los registros de la tabla Empleado uno por uno
            while (rs.next()) {
                // Se almacenan los registros obtenidos por la variable rs
                // de la tabla Empleado
                registro[0] = rs.getString("idEmpleado");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("tipoDocumento");
                registro[5] = rs.getString("numDocumento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("sueldo");
                registro[10] = rs.getString("acceso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("password");
                registro[13] = rs.getString("estado");
                
                // Aumenta el total de registros en 1
                totalRegistros = totalRegistros + 1;
                
                // Se agrega al modelo a manera de fila, todos los registros
                modelo.addRow(registro);
            }
            
            return modelo;
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
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
}
