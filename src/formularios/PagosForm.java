/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import clases.MetodosSueltos;
import clases.RendererPagos;
import clases.VariablesGlobales;
import es.discoduroderoer.swing.MiSwing;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernando
 */
public class PagosForm extends javax.swing.JDialog {

    private DefaultTableModel modelo;

    public PagosForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        rellenarPagos("");

        this.buttonGroup1.add(this.rdbTodos);
        this.buttonGroup1.add(this.rdbPagado);
        this.buttonGroup1.add(this.rdbNoPagado);

        MetodosSueltos.rellenarComboAlumno(cmbAlumno);
        this.setLocationRelativeTo(null);

    }

    private void rellenarPagos(String sqlAdicional) {

        String sqlBase = "select p.id_pago, ifnull(strftime('%d/%m/%Y', p.fecha),'Clase no pagada')  as fecha_pago, "
                + "ifnull(strftime('%d/%m/%Y', c.fecha),'Pendiente de realizar') as fecha_clase, a.nombre || apellidos as alumno, "
                + "c.precio as precio_clase, p.pagado "
                + "from clases c, pagos p, alumnos a "
                + "where c.id_clase = p.id_clase and a.id = c.id_alumno ";

        String sql = sqlBase + sqlAdicional;

        System.out.println(sql);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.tblPagos.setModel(modelo);

        this.tblPagos.setDefaultRenderer(Object.class, new RendererPagos());
        
        try {
            VariablesGlobales.conexion.ejecutarConsulta(sql);
            VariablesGlobales.conexion.rellenaJTableBD(modelo);
            MiSwing.ocultarColumnaJTable(tblPagos, 0);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPagos = new javax.swing.JTable();
        dtpFI = new com.toedter.calendar.JDateChooser();
        dtpFF = new com.toedter.calendar.JDateChooser();
        btnfiltrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        cmbAlumno = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rdbNoPagado = new javax.swing.JRadioButton();
        rdbPagado = new javax.swing.JRadioButton();
        rdbTodos = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblPagos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 123, 620, 400));
        getContentPane().add(dtpFI, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));
        getContentPane().add(dtpFF, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        btnfiltrar.setText("Filtrar");
        btnfiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfiltrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnfiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 36, 65, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(509, 70, -1, -1));

        cmbAlumno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(cmbAlumno, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 170, -1));

        jLabel1.setText("F. fin");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel2.setText("F. inicio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("Alumno");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        rdbNoPagado.setText("No pagado");
        getContentPane().add(rdbNoPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, 30));

        rdbPagado.setText("Pagado");
        rdbPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbPagadoActionPerformed(evt);
            }
        });
        getContentPane().add(rdbPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 80, 30));

        rdbTodos.setSelected(true);
        rdbTodos.setText("Todos");
        getContentPane().add(rdbTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 80, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdbPagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPagadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbPagadoActionPerformed

    private void btnfiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfiltrarActionPerformed

        String sqlAdicional = "";
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        String formatoFechaClase;

        boolean noPagadoAct = false, inicioAct = false;

        String parentesisApertura = "";
        String parentesisCierre = "";

        if (this.dtpFF.getDate() != null && this.dtpFI.getDate() != null) {
            parentesisApertura = "(";
            parentesisCierre = ")";
        }

        if (this.cmbAlumno.getSelectedIndex() != 0) {
            String[] filaCombobox = (String[]) (this.cmbAlumno.getSelectedItem());
            int codigoAlumno = Integer.parseInt(filaCombobox[0]);
            sqlAdicional += " and a.id = " + codigoAlumno;

        }

        if (!this.rdbTodos.isSelected()) {

            if (this.rdbPagado.isSelected()) {
                sqlAdicional += " and precio_clase = p.pagado";
            } else {
                sqlAdicional += " and (precio_clase <> p.pagado";
                noPagadoAct = true;
            }

        }

        if (this.dtpFI.getDate() != null) {

            formatoFechaClase = sdf.format(this.dtpFI.getDate());

            if (noPagadoAct) {
                sqlAdicional += " or " + parentesisApertura + " p.fecha >= '" + formatoFechaClase + "'";
            } else {
                sqlAdicional += " and p.fecha >= '" + formatoFechaClase + "'";
            }
            inicioAct=true;

        }

        if (this.dtpFF.getDate() != null) {
            formatoFechaClase = sdf.format(this.dtpFF.getDate());

            if (noPagadoAct) {
                if (inicioAct) {
                    sqlAdicional += " and p.fecha <= '" + formatoFechaClase + "'" + parentesisCierre;
                } else {
                    sqlAdicional += " or p.fecha <= '" + formatoFechaClase + "'" + parentesisCierre;
                }

            } else {
                sqlAdicional += " and p.fecha <= '" + formatoFechaClase + "'";
            }

        }

        if (noPagadoAct) {
            sqlAdicional += ")";
        }

        rellenarPagos(sqlAdicional);


    }//GEN-LAST:event_btnfiltrarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        MiSwing.limpiarFormulario(this.getContentPane().getComponents());
        this.rdbTodos.setSelected(true);
        rellenarPagos("");


    }//GEN-LAST:event_btnLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnfiltrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbAlumno;
    private com.toedter.calendar.JDateChooser dtpFF;
    private com.toedter.calendar.JDateChooser dtpFI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdbNoPagado;
    private javax.swing.JRadioButton rdbPagado;
    private javax.swing.JRadioButton rdbTodos;
    private javax.swing.JTable tblPagos;
    // End of variables declaration//GEN-END:variables
}
