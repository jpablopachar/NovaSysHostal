package Clases;

/*
    Author: Juan Pablo Pachar.
    Fecha: 3 de julio del 2017
    Modulo: Clase con los atributos de Empleado
 */

public class Empleado extends Persona {
    private double sueldo; // Sueldo del empleado
    private String acceso; // Tipo de acceso para el empleado
    private String login; // Login del empleado
    private String password; // Password del empleado
    private String estado; // Estado del empleado

    public Empleado() {
    }

    public Empleado(int idPersona, String nombre, String apellidoPaterno, 
        String apellidoMaterno, String tipoDocumento, String numDocumento, 
        String direccion, String telefono, String email, double sueldo, 
        String acceso, String login, String password, String estado) {
        super(idPersona, nombre, apellidoPaterno, apellidoMaterno, 
              tipoDocumento, numDocumento, direccion, telefono, email);
        this.sueldo = sueldo;
        this.acceso = acceso;
        this.login = login;
        this.password = password;
        this.estado = estado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}