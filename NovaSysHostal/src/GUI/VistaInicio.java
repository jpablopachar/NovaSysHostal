/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author jppachar
 */
public class VistaInicio extends javax.swing.JFrame {

    /**
     * Creates new form VistaInicio
     */
    public VistaInicio() {
        initComponents();
        // Instrucción para maximizar el formulario
        this.setExtendedState(VistaInicio.MAXIMIZED_BOTH); // Ocupa todo el tamaño de la pantalla
        // Nombre del formulario
        this.setTitle("Sistema de reserva de servicios para hosterias - NovaSysHostal");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        lblIdEmpleado = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        lblAcceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        mnuNovaSysHostal = new javax.swing.JMenu();
        menuArchivo = new javax.swing.JMenu();
        pasteMenuItem = new javax.swing.JMenuItem();
        mnuReservas = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenu();
        menuConfiguraciones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        mnuAyuda = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(255, 241, 218));

        lblIdEmpleado.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblIdEmpleado.setText("jLabel1");
        escritorio.add(lblIdEmpleado);
        lblIdEmpleado.setBounds(50, 40, 120, 17);

        lblNombre.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblNombre.setText("jLabel2");
        escritorio.add(lblNombre);
        lblNombre.setBounds(50, 80, 120, 17);

        lblApellidoPaterno.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblApellidoPaterno.setText("jLabel3");
        escritorio.add(lblApellidoPaterno);
        lblApellidoPaterno.setBounds(50, 120, 120, 17);

        lblApellidoMaterno.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblApellidoMaterno.setText("jLabel4");
        escritorio.add(lblApellidoMaterno);
        lblApellidoMaterno.setBounds(50, 160, 120, 17);

        lblAcceso.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblAcceso.setText("jLabel5");
        escritorio.add(lblAcceso);
        lblAcceso.setBounds(50, 200, 120, 17);

        mnuNovaSysHostal.setMnemonic('f');
        mnuNovaSysHostal.setText("NovaSysHostal");
        menuBar.add(mnuNovaSysHostal);

        menuArchivo.setMnemonic('e');
        menuArchivo.setText("Archivo");

        pasteMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/acercaDE.png"))); // NOI18N
        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Servicios");
        pasteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteMenuItemActionPerformed(evt);
            }
        });
        menuArchivo.add(pasteMenuItem);

        menuBar.add(menuArchivo);

        mnuReservas.setMnemonic('h');
        mnuReservas.setText("Reservas");

        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/reserva.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Reservas");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        mnuReservas.add(contentMenuItem);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/clientes.png"))); // NOI18N
        jMenuItem5.setText("Clientes");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuReservas.add(jMenuItem5);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/pagos.png"))); // NOI18N
        jMenuItem1.setText("Pagos");
        mnuReservas.add(jMenuItem1);

        menuBar.add(mnuReservas);

        mnuConsultas.setText("Consultas");
        menuBar.add(mnuConsultas);

        menuConfiguraciones.setText("Configuraciones");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/usuarios.png"))); // NOI18N
        jMenuItem2.setText("Usuarios y Accesos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuConfiguraciones.add(jMenuItem2);

        menuBar.add(menuConfiguraciones);

        mnuHerramientas.setText("Herramientas");
        menuBar.add(mnuHerramientas);

        mnuAyuda.setText("Ayuda");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/servicios.png"))); // NOI18N
        jMenuItem3.setText("Acerca de");
        mnuAyuda.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/ayuda.png"))); // NOI18N
        jMenuItem4.setText("Ayuda");
        mnuAyuda.add(jMenuItem4);

        menuBar.add(mnuAyuda);

        mnuSalir.setText("Salir");
        mnuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuSalirMouseClicked(evt);
            }
        });
        menuBar.add(mnuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pasteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteMenuItemActionPerformed
        // TODO add your handling code here:
        VistaServicio vistaServicio = new VistaServicio();
        
        escritorio.add(vistaServicio);
        vistaServicio.toFront();
        vistaServicio.setVisible(true);
    }//GEN-LAST:event_pasteMenuItemActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        VistaCliente vistaCliente = new VistaCliente();
        
        escritorio.add(vistaCliente);
        vistaCliente.toFront();
        vistaCliente.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        VistaEmpleado vistaEmpleado = new VistaEmpleado();
        
        escritorio.add(vistaEmpleado);
        vistaEmpleado.toFront();
        vistaEmpleado.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        // TODO add your handling code here:
        VistaReserva vistaReserva = new VistaReserva();
        
        escritorio.add(vistaReserva); // Agrego el formulario al escritorio
        vistaReserva.toFront(); // Aparecer delante de todos los formularios
        vistaReserva.setVisible(true); // Que sea visible
        VistaReserva.txtIdEmpleado.setText(lblIdEmpleado.getText()); // Recibe el idEmpleado que ha iniciado sesión
        // Recibe el nombre y el apellidoPaterno del usuario que ha iniciado sesión
        VistaReserva.txtEmpleado.setText(lblNombre.getText() + " " + lblApellidoPaterno.getText());
        VistaReserva.idUsuario = Integer.parseInt(lblIdEmpleado.getText()); // Recibe el idEmpleado que ha hecho la reserva
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void mnuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuSalirMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_mnuSalirMouseClicked

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
            java.util.logging.Logger.getLogger(VistaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JLabel lblAcceso;
    public static javax.swing.JLabel lblApellidoMaterno;
    public static javax.swing.JLabel lblApellidoPaterno;
    public static javax.swing.JLabel lblIdEmpleado;
    public static javax.swing.JLabel lblNombre;
    public static javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    public static javax.swing.JMenu menuConfiguraciones;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenu mnuNovaSysHostal;
    private javax.swing.JMenu mnuReservas;
    private javax.swing.JMenu mnuSalir;
    private javax.swing.JMenuItem pasteMenuItem;
    // End of variables declaration//GEN-END:variables

}
