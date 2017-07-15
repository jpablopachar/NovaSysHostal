package Clases;

import java.sql.Date;

/*
    Author: Juan Pablo Pachar.
    Fecha: 14 de julio del 2017
    Modulo: Clase con los atributos de Reserva
 */

public class Reserva {
    private int idReserva;
    private int idCliente;
    private int idEmpleado;
    private String tipoReserva; // Tipo de la reserva
    private Date fechaReserva; // Fecha de la reserva
    private Date fechaIngreso; // Fecha de ingreso de la reserva
    private Date fechaSalida; // Fecha de salida de la reserva
    private double costoAlojamiento; // Costo de alojamiento
    private String estado; // Estado de la reserva

    public Reserva() {
    }

    public Reserva(int idReserva, int idCliente, int idEmpleado,
            String tipoReserva, Date fechaReserva, Date fechaIngreso,
            Date fechaSalida, double costoAlojamiento, String estado) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.tipoReserva = tipoReserva;
        this.fechaReserva = fechaReserva;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.costoAlojamiento = costoAlojamiento;
        this.estado = estado;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getCostoAlojamiento() {
        return costoAlojamiento;
    }

    public void setCostoAlojamiento(double costoAlojamiento) {
        this.costoAlojamiento = costoAlojamiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    } 
}