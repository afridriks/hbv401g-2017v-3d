/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Trip;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import model.TripTableModel;

/**
 *
 * @author andri
 */
public class ResultsPanel extends javax.swing.JPanel {

    
    private final List<Trip> trips;
    
    /**
     * Creates new form ResultsWindow
     * @param results
     */
    public ResultsPanel(List<Trip> results) {
        trips = results;
    }
    
    
    private void showDetails(int tripId) {
        
    }
    
    private void searchAgain() {
        
    }
    
    public JScrollPane Show(){
        TableModel model = new TripTableModel(trips);
        JTable table = new JTable(model);
        table.removeColumn(table.getColumnModel().getColumn(14));
        table.removeColumn(table.getColumnModel().getColumn(12)); 
        table.removeColumn(table.getColumnModel().getColumn(11)); 
        table.removeColumn(table.getColumnModel().getColumn(10)); 
        table.removeColumn(table.getColumnModel().getColumn(7)); 
        table.removeColumn(table.getColumnModel().getColumn(6)); 
        table.removeColumn(table.getColumnModel().getColumn(5)); 
        table.removeColumn(table.getColumnModel().getColumn(0)); 
        JScrollPane panel = new JScrollPane(table);
        return panel;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bottomPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jButton1.setText("Book");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottomPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
