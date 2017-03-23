/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import controller.TripController;
import model.Trip;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;


/**
 *
 * @author Sigurlaug
 */
public class SearchPanel extends javax.swing.JFrame {

    private ResultsPanel panel;
    private final TripController controller;
    
    /**
     * Creates new form SearchWindow
     */
    public SearchPanel() throws SQLException {
        controller = new TripController();
        initComponents();
    }
    
    /**
     * 
     */
    private void search() throws SQLException, ClassNotFoundException {
        
        String tripName = "Hestaferðin";
        Date date = new Date(117, 05, 22);
        Time startTime = new Time(9, 0, 0);
        Time endTime = new Time(18, 0, 0);
        String description = "Skemmtileg hestaferð";
        boolean familyFriendly = false;
        boolean accessible = false;
        int minPrice = 10000;
        int maxPrice = 20000;
        int type = 2; // "Hestaferð"
        int location = 1;  // "Selfoss"        
        
        Trip[] results = controller.searchTrips(tripName, date, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
        for(Trip t : results) { 
            System.out.println("Leitarniðurstaða: " + t.getDescription()); }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UpperPanel = new javax.swing.JPanel();
        searchBox = new javax.swing.JTextField();
        typeCombo = new javax.swing.JComboBox<>();
        areaCombo = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboMonth = new javax.swing.JComboBox<>();
        comboYear = new javax.swing.JComboBox<>();
        comboDay = new javax.swing.JComboBox<>();
        resultsPanel = new view.ResultsPanel();
        myndJLabel = new javax.swing.JLabel();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(214, 217, 0));

        UpperPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchBox.setText("Enter keyword...");
        searchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBoxActionPerformed(evt);
            }
        });

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capital Area", "Eastern Region", "Southern Region", "Northern Region", "Western Region", "Highlands of Iceland", " " }));

        areaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Golden Circle", "Horse Trips", "Volcano", "Glaciers", "Beer Trips", "Food Trips" }));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/dayTrips.jpg"))); // NOI18N

        jRadioButton1.setText("Family friendly");

        jLabel1.setText("Area");

        jLabel2.setText("Type");

        jRadioButton2.setText("Accessible");

        jLabel3.setText("Year:");

        jLabel4.setText("Month:");

        jLabel5.setText("Day:");

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "Oktober", "November", "December" }));

        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020", "2021", "2022", "2023" }));

        comboDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        javax.swing.GroupLayout UpperPanelLayout = new javax.swing.GroupLayout(UpperPanel);
        UpperPanel.setLayout(UpperPanelLayout);
        UpperPanelLayout.setHorizontalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(searchBox, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(typeCombo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areaCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(UpperPanelLayout.createSequentialGroup()
                                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UpperPanelLayout.createSequentialGroup()
                                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                                .addComponent(jRadioButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jRadioButton1))
                                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(72, 72, 72)
                                                .addComponent(jLabel3)
                                                .addGap(64, 64, 64)
                                                .addComponent(jLabel5)))
                                        .addGap(14, 14, 14)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(titleLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UpperPanelLayout.setVerticalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)))
                        .addGap(6, 6, 6)
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(areaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton2)
                        .addComponent(jRadioButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        resultsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout resultsPanelLayout = new javax.swing.GroupLayout(resultsPanel);
        resultsPanel.setLayout(resultsPanelLayout);
        resultsPanelLayout.setHorizontalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        resultsPanelLayout.setVerticalGroup(
            resultsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        myndJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/aurora.jpg"))); // NOI18N

        fileMenu.setText("File");

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");
        jMenuBar1.add(editMenu);

        aboutMenu.setText("About");
        jMenuBar1.add(aboutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resultsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dateChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myndJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myndJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dateChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resultsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            search();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

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
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SearchPanel().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SearchPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UpperPanel;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JComboBox<String> areaCombo;
    private javax.swing.JComboBox<String> comboDay;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<String> comboYear;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel myndJLabel;
    private javax.swing.JPanel resultsPanel;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> typeCombo;
    // End of variables declaration//GEN-END:variables
}