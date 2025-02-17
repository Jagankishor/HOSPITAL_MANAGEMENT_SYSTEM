/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.sql.*;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jagan kishor
 */
public class VIEW_PATIENTS_MENU extends javax.swing.JInternalFrame {

    /**
     * Creates new form VIEW_PATIENTS_MENU
     */
    
    TableModel tm;
    Vector data;
    
    public VIEW_PATIENTS_MENU() {
        
        super("ADD Patient", true, true, true, true);
        initComponents();
        table_update();
        
        DefaultTableModel tm = (DefaultTableModel)jTable.getModel();
        data = tm.getDataVector();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        RESULT = new javax.swing.JLabel();
        WHERE = new javax.swing.JTextField();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking No", "Full Name ", "Date of Birth", "Gender", "Contact Number", "Address", "Current Medications", "Em Name", "Em Relationship", "Em Ph No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jButton1.setText("SHOW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        RESULT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        RESULT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        RESULT.setText("RESULT");
        RESULT.setBorder(new javax.swing.border.MatteBorder(null));

        WHERE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1230, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(WHERE, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RESULT, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(352, 352, 352))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RESULT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton4)
                        .addComponent(WHERE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        try {
                
            // Establishing the connection only  not registers already done
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");

             // Create a Statement object
            Statement st = con.createStatement();

            // SQL SELECT query
            ResultSet rs = st.executeQuery("SELECT * FROM add_patient_menu");

            // Get the metadata
            ResultSetMetaData RSMD = rs.getMetaData();

            // Get column count
            int CC = RSMD.getColumnCount();

            // Get the table model from your form table
            DefaultTableModel DFT = (DefaultTableModel) jTable.getModel();

            // Clear existing columns and data
            DFT.setRowCount(0);
            DFT.setColumnCount(0);

            // Add column names to the table model
            for (int i = 1; i <= CC; i++) {
                DFT.addColumn(RSMD.getColumnName(i));
            }

            // Process the result set and add rows to the table model
            while (rs.next()) 
            {
                Vector v2 = new Vector();
                for (int i = 1; i <= CC; i++) 
                {
                    v2.add(rs.getString(i));
                }
                DFT.addRow(v2);
            }
            
            RESULT.setText("SHOW DATA");
        } 
            catch (Exception e) 
            {
                System.out.println("Exception: " + e);
            } 
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        
        // Get the table model from your form table
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        int selectedIndex = jTable.getSelectedRow();
        
        WHERE.setText(model.getValueAt(selectedIndex, 0).toString());
        
    }//GEN-LAST:event_jTableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        try {
            // Register MySQL JDBC driver
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            // EstablishQA the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "");

            // Create a Statement object
            Statement st = con.createStatement();
            
            // SQL UPDATE query
            String updateSql = "DELETE FROM add_patient_menu WHERE BOOKING_NO = "+WHERE.getText()+";";
                                                                                        
            int rowsAffected = st.executeUpdate(updateSql);

            RESULT.setText("A Row was Deleted successfully!");
            System.out.println("A Row was Deleted successfully!");

        } 
        
        catch (Exception e) 
            {
                System.out.println("Exception: " + e);
            }
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(VIEW_PATIENTS_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VIEW_PATIENTS_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VIEW_PATIENTS_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIEW_PATIENTS_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIEW_PATIENTS_MENU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel RESULT;
    private javax.swing.JTextField WHERE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables

    private void table_update() {
        
        
        
        
        }
}
