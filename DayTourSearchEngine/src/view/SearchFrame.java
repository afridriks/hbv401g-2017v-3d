/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import controller.TripController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import model.Trip;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


/**
 *
 * @author Sigurlaug
 */
public class SearchFrame extends javax.swing.JFrame {

    private ResultsPanel panel;
    private BookTripPanel bookingPanel;
    private final TripController controller;
    
    /**
     * Creates new form SearchWindow
     * @throws java.sql.SQLException
     */
    public SearchFrame() throws SQLException {
        controller = new TripController();
        initComponents();
        
    }
    
    /**
     * 
     */
    private void search() throws SQLException, ClassNotFoundException {
        sidePanel.setVisible(false);
        infoButton.setEnabled(true);
        
        //         Mock objects.         //
        ///////////////////////////////////
        String tripName = "Hestaferðin";
        Date date = new Date(117, 05, 22);
        Time startTime = new Time(9, 0, 0);
        Time endTime = new Time(18, 0, 0);
        String description = "Skemmtileg hestaferð";
        boolean familyFriendly = false;
        boolean accessible = false;
        int minPrice = 10000;
        int maxPrice = 20000;
        int type = 2;
        int location = 1;
        /*
        // Extract date on sql-format from Calendar.
        Calendar d = dateChooser.getSelectedDate();
        java.sql.Date date = new java.sql.Date(d.getTimeInMillis() );
        
        // Extract name of trip from textArea.
        String tripName = nameSearchBox.getText();
        
        // Extract keywords to be used for searching.
        String description = keyWordSearchBox.getText();
        
        // Extract boolean values.
        Boolean familyFriendly = familyFriendlyButton.isSelected();
        Boolean accessible = accessibleButton.isSelected();
        
        // Extract price from sliders.
        int minPrice = jSlider1.getValue()*1000;
        int maxPrice = jSlider2.getValue()*1000;
        
       // Extract startTime from spinner
       Time startTime = new Time(
               Integer.parseInt(startTimeSpinner.getValue().toString().subSequence(11, 13).toString()),
               Integer.parseInt(startTimeSpinner.getValue().toString().subSequence(14, 16).toString()),
               0
       );
              
       
       // Extract endTime from spinner
       Time endTime = new Time(
               Integer.parseInt(endTimeSpinner.getValue().toString().subSequence(11, 13).toString()),
               Integer.parseInt(endTimeSpinner.getValue().toString().subSequence(14, 16).toString()),
               0
       );

       // Get Type and Area.
       int type = typeCombo.getSelectedIndex()+1; // "Hestaferð"
       int location = areaCombo.getSelectedIndex()+1;  // "Selfoss"   

              
       // Execute search and display
       /*System.out.println(tripName);
       System.out.println(date);
       System.out.println(startTime);
       System.out.println(endTime);
       System.out.println(description);
       System.out.println(familyFriendly);
       System.out.println(accessible);
       System.out.println(minPrice);
       System.out.println(maxPrice);
       System.out.println(type);
       System.out.println(location);*/
       
        Trip[] results = controller.searchTrips(tripName, date, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
        List<Trip> res = Arrays.asList(results);
        panel = new ResultsPanel(res);
        JScrollPane sPane = panel.Show();
        this.add(sPane);
        sPane.setSize(sidePanel.getSize());
        sPane.setLocation(sidePanel.getLocation());
        this.validate();
        this.repaint();
        
    }
    
    private void showInfo(Trip selectedRow) {
        jPanel3.setVisible(false);
        List<Trip> res = Arrays.asList(selectedRow);
        bookingPanel = new BookTripPanel(res);
        JScrollPane sPane = bookingPanel.Show();
        this.add(sPane);
        sPane.setSize(jPanel3.getSize());
        sPane.setLocation(jPanel3.getLocation());
        this.validate();
        this.repaint();
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
        nameSearchBox = new javax.swing.JTextField();
        areaCombo = new javax.swing.JComboBox<>();
        typeCombo = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        familyFriendlyButton = new javax.swing.JRadioButton();
        areaLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        accessibleButton = new javax.swing.JRadioButton();
        dateChooser = new datechooser.beans.DateChooserPanel();
        startTimeLabel = new javax.swing.JLabel();
        java.util.Date startTimeSpinnerDate = new Date(System.currentTimeMillis());
        SpinnerDateModel sm = new SpinnerDateModel( startTimeSpinnerDate,
            null,
            null,
            Calendar.HOUR_OF_DAY);
        startTimeSpinner = new javax.swing.JSpinner(sm);
        endTimeLabel = new javax.swing.JLabel();
        java.util.Date endTimeSpinnerDate = new Date(System.currentTimeMillis());
        SpinnerDateModel em = new SpinnerDateModel( endTimeSpinnerDate,
            null,
            null,
            Calendar.HOUR_OF_DAY);
        endTimeSpinner = new javax.swing.JSpinner(em);
        keyWordSearchBox = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider(0, 50000, 25000);
        jSlider2 = new javax.swing.JSlider(0, 50000, 25000);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        infoButton = new javax.swing.JButton();
        sidePanel = new javax.swing.JPanel();
        myndJLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(214, 217, 0));

        UpperPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nameSearchBox.setToolTipText("Enter name...");
        nameSearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameSearchBoxActionPerformed(evt);
            }
        });

        areaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capital Area", "Eastern Region", "Southern Region", "Northern Region", "Western Region", "Highlands of Iceland", " " }));

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Golden Circle", "Horse Trips", "Volcano", "Glaciers", "Beer Trips", "Food Trips" }));
        typeCombo.setActionCommand("");
        typeCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeComboActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/dayTrips.jpg"))); // NOI18N

        familyFriendlyButton.setText("Family friendly");

        areaLabel.setText("Area");

        typeLabel.setText("Type");

        accessibleButton.setText("Accessible");

        dateChooser.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserOnSelectionChange(evt);
            }
        });

        startTimeLabel.setText("Start time:");

        JSpinner.DateEditor de = new JSpinner.DateEditor(startTimeSpinner,
            "HH:mm");
        startTimeSpinner.setEditor(de);

        endTimeLabel.setText("End time:");

        JSpinner.DateEditor dee = new JSpinner.DateEditor(endTimeSpinner,
            "HH:mm");
        endTimeSpinner.setEditor(dee);
        // Code adding the component to the parent container - not shown here

        keyWordSearchBox.setToolTipText("Enter keyword...");
        keyWordSearchBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyWordSearchBoxActionPerformed(evt);
            }
        });

        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMaximum(50);
        jSlider1.setMinorTickSpacing(5);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(25);

        jSlider2.setMajorTickSpacing(10);
        jSlider2.setMaximum(50);
        jSlider2.setMinorTickSpacing(5);
        jSlider2.setPaintLabels(true);
        jSlider2.setPaintTicks(true);
        jSlider2.setSnapToTicks(true);
        jSlider2.setValue(25);

        jLabel1.setText("Mininum price:");

        jLabel2.setText("Maximum price:");

        javax.swing.GroupLayout UpperPanelLayout = new javax.swing.GroupLayout(UpperPanel);
        UpperPanel.setLayout(UpperPanelLayout);
        UpperPanelLayout.setHorizontalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(titleLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accessibleButton)
                                    .addComponent(familyFriendlyButton)
                                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(typeLabel))
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(areaLabel)))
                        .addGap(39, 39, 39)
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(UpperPanelLayout.createSequentialGroup()
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addComponent(startTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(84, 84, 84))))
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UpperPanelLayout.createSequentialGroup()
                                .addComponent(nameSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(keyWordSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 17, Short.MAX_VALUE))
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        UpperPanelLayout.setVerticalGroup(
            UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpperPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keyWordSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(typeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(accessibleButton)
                        .addGap(11, 11, 11)
                        .addComponent(familyFriendlyButton))
                    .addGroup(UpperPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startTimeLabel)
                            .addComponent(startTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endTimeLabel)
                            .addComponent(endTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(UpperPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.setMaximumSize(new java.awt.Dimension(67, 82));
        jPanel1.setMinimumSize(new java.awt.Dimension(67, 82));

        infoButton.setText("More Information");
        infoButton.setEnabled(false);
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        myndJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/aurora.jpg"))); // NOI18N
        myndJLabel.setMaximumSize(new java.awt.Dimension(560, 478));
        myndJLabel.setMinimumSize(new java.awt.Dimension(560, 478));
        myndJLabel.setPreferredSize(new java.awt.Dimension(560, 478));

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidePanelLayout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(myndJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(myndJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1428, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

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
                .addGap(37, 37, 37)
                .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(UpperPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void dateChooserOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserOnSelectionChange

    }//GEN-LAST:event_dateChooserOnSelectionChange

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            search();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SearchFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void nameSearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameSearchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameSearchBoxActionPerformed

    private void keyWordSearchBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyWordSearchBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keyWordSearchBoxActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        Trip selectedRow = panel.getSelectedRow();
        System.out.println(selectedRow.getName());

        showInfo(selectedRow);
        
    }//GEN-LAST:event_infoButtonActionPerformed

    private void typeComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeComboActionPerformed
       
    }//GEN-LAST:event_typeComboActionPerformed

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
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new SearchFrame().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(SearchFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UpperPanel;
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JRadioButton accessibleButton;
    private javax.swing.JComboBox<String> areaCombo;
    private javax.swing.JLabel areaLabel;
    private datechooser.beans.DateChooserPanel dateChooser;
    private javax.swing.JMenu editMenu;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JSpinner endTimeSpinner;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JRadioButton familyFriendlyButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTextField keyWordSearchBox;
    private javax.swing.JLabel myndJLabel;
    private javax.swing.JTextField nameSearchBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JSpinner startTimeSpinner;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}