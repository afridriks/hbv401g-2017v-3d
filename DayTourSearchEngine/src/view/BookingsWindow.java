/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TripController;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.Booking;
import model.BookingsTableModel;
import model.TourCompany;


/**
 *
 * @author Einar Andreas Helgason, Háskóli Íslands, eah8@hi.is
 */
public class BookingsWindow extends javax.swing.JFrame {

    private TripController controller;
    private JTable table;
    private List<Booking> bookings;
    JScrollPane jBookingsScrollPane;
    
    /**
     * Creates new form BookingsWindow
     */
    public BookingsWindow(TripController controller) {
        initComponents();
        this.controller = controller;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCancelBooking = new javax.swing.JButton();
        jTourCompanyInfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jNameTextField = new javax.swing.JTextField();
        jSearchBookings = new javax.swing.JButton();
        jBookingsPanel = new javax.swing.JPanel();
        jCloseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bookings");

        jCancelBooking.setText("Cancel booking");
        jCancelBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelBookingActionPerformed(evt);
            }
        });

        jTourCompanyInfo.setText("Tour Company Info");
        jTourCompanyInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTourCompanyInfoActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter name:");

        jSearchBookings.setText("Search for bookings");
        jSearchBookings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSearchBookingsActionPerformed(evt);
            }
        });

        jBookingsPanel.setBackground(new java.awt.Color(255, 255, 255));
        jBookingsPanel.setOpaque(false);

        javax.swing.GroupLayout jBookingsPanelLayout = new javax.swing.GroupLayout(jBookingsPanel);
        jBookingsPanel.setLayout(jBookingsPanelLayout);
        jBookingsPanelLayout.setHorizontalGroup(
            jBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 937, Short.MAX_VALUE)
        );
        jBookingsPanelLayout.setVerticalGroup(
            jBookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );

        jCloseButton.setText("Close window");
        jCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSearchBookings, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTourCompanyInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(150, 150, 150)
                            .addComponent(jCancelBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jBookingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSearchBookings))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBookingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTourCompanyInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCancelBooking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSearchBookingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSearchBookingsActionPerformed
        // TODO add your handling code here:
        String name = jNameTextField.getText();
        try {
            bookings = Arrays.asList(controller.GetBookingsByName(name));
            displayBookings();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(BookingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jSearchBookingsActionPerformed

    private void jCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCloseButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jCloseButtonActionPerformed

    private void jTourCompanyInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTourCompanyInfoActionPerformed
        // TODO add your handling code here:
        TourCompany tc = getTourCompany();
        if(tc != null) {
           TourCompanyWindow tcWindow = new TourCompanyWindow(tc);
           tcWindow.setVisible(true); 
        }
        
    }//GEN-LAST:event_jTourCompanyInfoActionPerformed

    private void jCancelBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelBookingActionPerformed
        try {
            // TODO add your handling code here:
            if(getSelectedRow() != null)
                controller.cancelBooking(getSelectedRow());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BookingsWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jCancelBookingActionPerformed

    private void displayBookings() {
        if(jBookingsScrollPane != null){
            this.remove(jBookingsScrollPane);
        }
        System.out.println(bookings.size());
        jBookingsScrollPane = Show();
        this.add(jBookingsScrollPane);
        jBookingsScrollPane.setSize(jBookingsPanel.getSize());
        jBookingsScrollPane.setLocation(jBookingsPanel.getLocation());   
        this.validate();
        this.repaint();        
    }
    
    
    public JScrollPane Show(){
        TableModel model = new BookingsTableModel(bookings);
        table = new JTable(model);
        JScrollPane panel = new JScrollPane(table);
        return panel;
    }
    
    public Booking getSelectedRow(){
        if(table != null) {
            int index = table.getSelectedRow();
            if(index == -1) return null;
            return bookings.get(index);
        }
        return null;
    }
    
    private TourCompany getTourCompany() {
        Booking selectedBooking = getSelectedRow();
        if(selectedBooking == null) return null;
        return selectedBooking.getTrip().getTourCompany();
    }
    
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
            java.util.logging.Logger.getLogger(BookingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingsWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BookingsWindow(new TripController()).setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BookingsWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jBookingsPanel;
    private javax.swing.JButton jCancelBooking;
    private javax.swing.JButton jCloseButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jNameTextField;
    private javax.swing.JButton jSearchBookings;
    private javax.swing.JButton jTourCompanyInfo;
    // End of variables declaration//GEN-END:variables
}
