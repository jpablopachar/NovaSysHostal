package Clases;

import java.sql.Date;

/*
    Author: Juan Pablo Pachar.
    Fecha: 22 de julio del 2017
    Modulo: Clase con los atributos de Pago
 */

public class Pago {
    private int idPago;
    private int idReserva;
    private String tipoComprobante; // Tipo de comprobante del pago
    private String numComprobante; // Número de comprobante del pago
    private double iva; // IVA del pago
    private double totalPago; // Total de pago
    private Date fechaEmision; // Fecha de emision del comprobante
    private Date fechaPago; // Fecha de pago del comprobante

    public Pago() {
    }

    public Pago(int idPago, int idReserva, String tipoComprobante,
        String numComprobante, double iva, double totalPago, Date fechaEmision,
        Date fechaPago) {
        this.idPago = idPago;
        this.idReserva = idReserva;
        this.tipoComprobante = tipoComprobante;
        this.numComprobante = numComprobante;
        this.iva = iva;
        this.totalPago = totalPago;
        this.fechaEmision = fechaEmision;
        this.fechaPago = fechaPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumComprobante() {
        return numComprobante;
    }

    public void setNumComprobante(String numComprobante) {
        this.numComprobante = numComprobante;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(double totalPago) {
        this.totalPago = totalPago;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}