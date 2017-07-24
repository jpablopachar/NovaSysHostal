/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Clases.Pago;
import Clases.Reserva;
import Clases.Servicio;
import Database.DBConsumo;
import Database.DBPago;
import Logica.LogicaConsumo;
import Logica.LogicaPago;
import Logica.LogicaReserva;
import Logica.LogicaServicio;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jppachar
 */
public class VistaPago extends javax.swing.JInternalFrame {
    public static String idReserva;
    public static String cliente;
    public static double totalReserva;

    /**
     * Creates new form VistaServicio
     */
    
    // txtIdPago
    public VistaPago() {
        initComponents();
        mostrar(idReserva);
        inHabilitar();
        txtIdReserva.setText(idReserva);
        txtCliente.setText(cliente);
        txtTotalReserva.setText(Double.toString(totalReserva));
        
        DBConsumo dbConsumo = new DBConsumo();
        
        dbConsumo.consultar(idReserva); // Muestra solo los consumos de la reserva específica
        // El totala pagar es igual al total de la reserva más el total de todos los consumos
        txtTotalPago.setText(Double.toString(totalReserva + dbConsumo.totalConsumo));
    }
    
    // Determina si la acción que se ejecuta es guardar o editar
    private String accion = "guardar";
    
    // Procedimiento para ocultar la columna de idPago e idReserva
    void ocultarColumna() {
        // De la tablaListado la columna 0 = 0, 1 = 1
        tablaListado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(0).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListado.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListado.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    
    // Procedimiento para ocultar la columna de idConsumo, idReserva e idServicio
    void ocultarColumnaConsumos() {
        // De la tablaListadoConsumos la columna 0 = 0, 1 = 1, 2 = 2
        tablaListadoConsumos.getColumnModel().getColumn(0).setMaxWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(0).setMinWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(0).setPreferredWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(1).setMinWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(1).setPreferredWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(2).setMinWidth(0);
        tablaListadoConsumos.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    // Procedimiento para deshabilitar todas las cajas de textos y botones
    void inHabilitar() {
        txtIdPago.setVisible(false);
        txtIdReserva.setVisible(false);
        txtTotalReserva.setEnabled(false);
        cboTipoComprobante.setEnabled(false);
        txtNumComprobante.setEnabled(false);
        txtIva.setEnabled(false);
        txtTotalPago.setEnabled(false);
        dcFechaEmision.setEnabled(false);
        dcFechaPago.setEnabled(false);
        
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
        txtIdPago.setText("");
        txtNumComprobante.setText("");
        txtIva.setText("");
        txtTotalPago.setText("");
    }
    
    // Procedimiento para habilitar todas las cajas de textos y botones
    void habilitar() {
        txtIdPago.setVisible(false);
        txtIdReserva.setVisible(true);
        txtTotalReserva.setEnabled(true);
        cboTipoComprobante.setEnabled(true);
        txtNumComprobante.setEnabled(true);
        txtIva.setEnabled(true);
        txtTotalPago.setEnabled(true);
        dcFechaEmision.setEnabled(true);
        dcFechaPago.setEnabled(true);
        
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnEliminar.setEnabled(true);
        
        txtIdPago.setText("");
        txtNumComprobante.setText("");
        txtIva.setText("");
        //txtTotalPago.setText("");
    }
    
    // Procedimiento para que realizar la busqueda
    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            
            // Instancia de la clase LogicaPago
            DBPago dbPago = new DBPago();
            // Almacena el resultado del metodo mostrar de la clase LogicaPago
            modelo = dbPago.consultar(buscar);
            
            tablaListado.setModel(modelo);
            ocultarColumna();
            totalRegistros.setText("Total Pagos: " + Integer.toString(dbPago.totalRegistros));
            
            // Muestra los datos de los consumos
            DBConsumo logicaConsumo = new DBConsumo();
            modelo = logicaConsumo.consultar(buscar);
            
            tablaListadoConsumos.setModel(modelo);
            ocultarColumnaConsumos();
            totalRegistrosConsumos.setText("Total de consumos: " + logicaConsumo.totalRegistros);
            totalConsumo.setText("Consumo total: $." + logicaConsumo.totalConsumo);    
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtIdPago = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNumComprobante = new javax.swing.JTextField();
        cboTipoComprobante = new javax.swing.JComboBox<>();
        txtIdReserva = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        dcFechaPago = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        dcFechaEmision = new com.toedter.calendar.JDateChooser();
        txtIva = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTotalPago = new javax.swing.JTextField();
        txtTotalReserva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        totalRegistros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaListadoConsumos = new javax.swing.JTable();
        totalRegistrosConsumos = new javax.swing.JLabel();
        totalConsumo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 87, 34));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pago");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("IVA:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo de comprobante:");

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/return.png"))); // NOI18N
        btnCancelar.setText("Cancelar");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reserva:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Num comprobante:");

        cboTipoComprobante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Factura", "Nota de venta" }));

        txtIdReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdReservaActionPerformed(evt);
            }
        });

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha de pago:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Fecha de emisión:");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total a pagar:");

        jLabel12.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total reserva:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addGap(62, 62, 62))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIdPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCliente)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cboTipoComprobante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNumComprobante)
                        .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dcFechaEmision, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                        .addComponent(dcFechaPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtIdPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboTipoComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcFechaEmision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)
                    .addComponent(btnNuevo))
                .addGap(102, 102, 102))
        );

        jPanel1.setBackground(new java.awt.Color(255, 87, 34));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Pagos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaListado);

        totalRegistros.setForeground(new java.awt.Color(255, 255, 255));
        totalRegistros.setText("Registros:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalRegistros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSalir)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalRegistros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 87, 34));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado de Consumos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tablaListadoConsumos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaListadoConsumos);

        totalRegistrosConsumos.setForeground(new java.awt.Color(255, 255, 255));
        totalRegistrosConsumos.setText("Registros:");

        totalConsumo.setForeground(new java.awt.Color(255, 255, 255));
        totalConsumo.setText("jLabel2");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totalConsumo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(totalRegistrosConsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalRegistrosConsumos)
                    .addComponent(totalConsumo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtIdReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdReservaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        // Valida que al presionar guardar las cajas de texto tengan contenido
        
        // Valida el número de comprobante a pagar
        if (txtNumComprobante.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el número de comprobante a pagar");
            // Enviamos el enfoque a la caja de texto correspondiente
            txtNumComprobante.requestFocus();
            return;
        }
        
        // Valida el IVA del comprobante a pagar
        if (txtIva.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el IVA del comprobante a pagar");
            // Enviamos el enfoque a la caja de texto correspondiente
            txtIva.requestFocus();
            return;
        }

        // Valida el total a pagar del comprobante
        if (txtTotalPago.getText().length() == 0) {
            JOptionPane.showConfirmDialog(rootPane, "Debes ingresar el total a pagar del comprobante");
            txtTotalPago.requestFocus();
            return;
        }
        
        // idReserva

        // Instanciamos la clase y las funciones del Pago
        Pago pago = new Pago();
        LogicaPago logicaPago = new LogicaPago();

        // Enviamos los datos hacia los metodos set de la clase Pago
        pago.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
        pago.setNumComprobante(txtNumComprobante.getText());
        pago.setIva(Double.parseDouble(txtIva.getText()));
        pago.setTotalPago(Double.parseDouble(txtTotalPago.getText()));

        // comboBox Tipo de comprobante
        int seleccionado = cboTipoComprobante.getSelectedIndex();
        pago.setTipoComprobante((String)cboTipoComprobante.getItemAt(seleccionado));
        
        // Para trabajar con las fechas ---------------------------------------
        Calendar calendar;
        int dia, mes, anio;
        
        // Fecha de emisión
        calendar = dcFechaEmision.getCalendar();
        dia = calendar.get(Calendar.DAY_OF_MONTH); // Obtiene un día del mes
        mes = calendar.get(Calendar.MONTH); // Obtiene el mes
        anio = calendar.get(Calendar.YEAR) - 1900; // Obtiene el año
        
        pago.setFechaEmision(new Date(anio, mes, dia));
        
        // Fecha de pago
        calendar = dcFechaPago.getCalendar();
        dia = calendar.get(Calendar.DAY_OF_MONTH); // Obtiene un día del mes
        mes = calendar.get(Calendar.MONTH); // Obtiene el mes
        anio = calendar.get(Calendar.YEAR) - 1900; // Obtiene el año
        
        pago.setFechaPago(new Date(anio, mes, dia));
        
        // Acción para guardar
        if (accion.equals("guardar")) {
            if (logicaPago.insertar(pago)) {
                JOptionPane.showMessageDialog(rootPane, "El pago por $. " + txtTotalPago.getText() +
                    " del Sr. " + txtCliente.getText() + " ha sido realizado correctamente");
                mostrar(idReserva); // Muestra solo el pago de una reserva específica
                inHabilitar();
                
                /*// Desocupa el servicio
                LogicaServicio logicaServicio = new LogicaServicio();
                Servicio servicio = new Servicio();
                
                servicio.setIdServicio(Integer.parseInt(txtIdServicio.getText()));
                logicaServicio.desocupar(servicio);*/
                
                // Pagar la reserva
                LogicaReserva logicaReserva = new LogicaReserva();
                Reserva reserva = new Reserva();
                
                reserva.setIdReserva(Integer.parseInt(txtIdReserva.getText()));
                logicaReserva.pagar(reserva);  
            }
        } else if (accion.equals("editar")) { // Acción para Editar
            pago.setIdPago(Integer.parseInt(txtIdPago.getText()));

            if (logicaPago.editar(pago)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del Sr. " + txtCliente.getText() + " fue editado correctamente");
                mostrar(idReserva); // Muestra solo el pago de una reserva específica
                inHabilitar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        // Evalua que mi txtIdPago no esté vacía
        if (!txtIdPago.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Estás seguro de eliminar el pago?","Confirmar",2);

            // Si el usuario confirma se procede a la eliminación
            if (confirmacion == 0) {
                LogicaPago logicaPago = new LogicaPago();
                Pago pago = new Pago();

                pago.setIdPago(Integer.parseInt(txtIdPago.getText()));
                logicaPago.eliminar(pago);
                mostrar(idReserva); // Muestra solo el pago de una reserva específica
                inHabilitar();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListadoMouseClicked
        // TODO add your handling code here:
        btnGuardar.setText("Editar");
        habilitar();
        btnEliminar.setEnabled(true);
        accion = "editar";

        int fila = tablaListado.rowAtPoint(evt.getPoint());

        txtIdPago.setText(tablaListado.getValueAt(fila, 0).toString());
        //txtIdReserva.setText(tablaListado.getValueAt(fila, 1).toString());
        cboTipoComprobante.setSelectedItem(tablaListado.getValueAt(fila, 2).toString());
        txtNumComprobante.setText(tablaListado.getValueAt(fila, 3).toString());
        txtIva.setText(tablaListado.getValueAt(fila, 4).toString());
        txtTotalPago.setText(tablaListado.getValueAt(fila, 5).toString());
        //txtTotalPago.setText(tablaListado.getValueAt(fila, 5).toString());
        dcFechaEmision.setDate(Date.valueOf(tablaListado.getValueAt(fila, 6).toString()));
        dcFechaPago.setDate(Date.valueOf(tablaListado.getValueAt(fila, 7).toString()));
    }//GEN-LAST:event_tablaListadoMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        habilitar();
        // Boton en su caption Guardar
        btnGuardar.setText("Guardar");

        accion = "guardar";
    }//GEN-LAST:event_btnNuevoActionPerformed
//txtIdEmpleado
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cboTipoComprobante;
    private com.toedter.calendar.JDateChooser dcFechaEmision;
    private com.toedter.calendar.JDateChooser dcFechaPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaListado;
    private javax.swing.JTable tablaListadoConsumos;
    private javax.swing.JLabel totalConsumo;
    private javax.swing.JLabel totalRegistros;
    private javax.swing.JLabel totalRegistrosConsumos;
    public static javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtIdPago;
    public static javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNumComprobante;
    private javax.swing.JTextField txtTotalPago;
    private javax.swing.JTextField txtTotalReserva;
    // End of variables declaration//GEN-END:variables
}
