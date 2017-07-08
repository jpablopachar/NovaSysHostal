package Logica;

import Clases.Cliente;
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
    Modulo: Permite mostrar, insertar, editar, eliminar un cliente
*/

public class LogicaCliente {
    private Conexion mysql = new Conexion(); // Instancia la clase Conexion
    private Connection cn = mysql.conectar(); // Llama a la función conectar
    private String sSQL = ""; // Almacena el codigo SQL
    public int totalRegistros; // Cuenta el total de registros
    
    // Muestra los regsitros de la BD de la tabla Cliente
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        // Arreglo que hace una referencia de los titulos de las columnas
        // de la tabla
        String[] titulos = {"id", "Nombre", "Apellido paterno",
            "Apellido materno", "Tipo de documento", "Número de documento",
            "Dirección", "Teléfono", "Email", "Código del cliente"};
        
        // Arreglo que almacena los registros de cada titulo
        String[] registro = new String[10];
        totalRegistros = 0;
        // Se agrega los titulos de la tabla
        modelo = new DefaultTableModel(null, titulos);
        
        // Selecciona los registros de la tabla Cliente y filtra por
        // idCliente según el parámetro a buscar de forma descendente
        sSQL = "select * from Cliente where numDocumento like '%" + buscar +
               "%' order by idCliente desc";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL); // Ejecuta la instrucción SQL
            
            // Recorre los registros de la tabla Cliente uno por uno
            while (rs.next()) {
                // Se almacenan los registros obtenidos por la variable rs
                // de la tabla Cliente
                registro[0] = rs.getString("idCliente");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("apellidoPaterno");
                registro[3] = rs.getString("apellidoMaterno");
                registro[4] = rs.getString("tipoDocumento");
                registro[5] = rs.getString("numDocumento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("codigoCliente");
                
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
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
            // Contiene la cadena SQL para modificar un registro
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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
            // Contiene la cadena SQL para modificar un registro
            PreparedStatement pst = cn.prepareStatement(sSQL);
            
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