package Clases;

/*
    Author: Juan Pablo Pachar.
    Fecha: 16 de julio del 2017
    Modulo: Clase con los atributos de Servicio
 */

public class Servicio {
    private int idServicio;
    private String nombre; // Nombre del servicio
    private double cantidad; // Cantidad disponible
    private String descripcion; // Descripción del servicio
    private String caracteristicas; // Característica del servicio
    private double precio; // Precio del servicio
    private String estado; // Estado del servicio

    public Servicio() {
    }

    public Servicio(int idServicio, String nombre, double cantidad,
            String descripcion, String caracteristicas, double precio,
            String estado) {
        this.idServicio = idServicio;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
        this.estado = estado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }   
}