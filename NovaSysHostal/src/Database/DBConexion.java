package Database;

import Logica.LogicaConexion;
import java.sql.SQLException;

/*
    Author: Juan Pablo Pachar.
    Fecha: 20 de julio del 2017
    Modulo: Clase que permite conexión hacia la base de datos
 */

public class DBConexion {
    LogicaConexion logicaConexion = new LogicaConexion();
    
    public void cerrarConexion() throws SQLException {
        logicaConexion.cerrarConexion();
    }
}
