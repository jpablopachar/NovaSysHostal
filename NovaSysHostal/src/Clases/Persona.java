package Clases;

/*
    Author: Juan Pablo Pachar.
    Fecha: 3 de julio del 2017
    Modulo: Clase con los atributos de Persona
 */

public class Persona {
    private int idPersona;
    private String nombre; // Nombre de la persona
    private String apellidoPaterno; // Apellido paterno de la persona
    private String apellidoMaterno; // Apellido materno de la persona
    private String tipoDocumento; // Tipo de documento de la persona
    private String numDocumento; // Numero del documento de la persona
    private String direccion; // Dirección de la persona
    private String telefono; // Telefono de la persona
    private String email; // Email de la persona

    public Persona() {
    }

    public Persona(int idPersona, String nombre, String apellidoPaterno, String apellidoMaterno, String tipoDocumento, String numDocumento, String direccion, String telefono, String email) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}