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
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import model.TourCompany;


/**
 *
 * @author Sigurlaug
 */
public class SearchFrame extends javax.swing.JFrame {

    private ResultsPanel panel;
    private BookTripPanel bookingPanel;
    private final TripController controller;
    private Trip[] results;
    private JScrollPane sPane;
    private JScrollPane bookSPane;
    
    /**
     * Creates new form SearchWindow
     * @throws java.sql.SQLException
     */
    public SearchFrame() throws SQLException {
        controller = new TripController();
        initComponents();
        bookButton.setVisible(false);
        bookingInfoPanel.setVisible(false);
        infoPanel.setVisible(false);
    }
    
    /**
     * 
     */
    private void search() throws SQLException, ClassNotFoundException {

        
        // Harðkóðuð leit sem virkar //
            /*
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
        */
        
        
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
       //int type = typeCombo.getSelectedIndex()+1; // t.d. "Hestaferð"
       String type = "Hestaferð";
       //int location = areaCombo.getSelectedIndex()+1;  // t.d. "Selfoss"   
       String location = "Selfoss";


       /*       
       // Execute search and display
       System.out.println(tripName);
       System.out.println(date);
       System.out.println(startTime);
       System.out.println(endTime);
       System.out.println(description);
       System.out.println(familyFriendly);
       System.out.println(accessible);
       System.out.println(minPrice);
       System.out.println(maxPrice);
       System.out.println(type);
       System.out.println(location); */
        if(minPrice > maxPrice) {
           showDialog("Minimum price must be lower than maximum price.");
        } else if(endTime.before(startTime)) {
            showDialog("Start time must be before end time");
        } else {
            sidePanel.setVisible(false);
            infoPanel.setVisible(true);
            results = controller.searchTrips(tripName, date, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
            Trip[] sorted = controller.sortTripsByName(results);
            showResults(sorted);
            this.validate();
            this.repaint();
        }
        
    }
    
    private void showResults(Trip[] results) {
        JComponent pane;
        if(sPane != null){
            pane = sPane;
            this.remove(sPane);
        }
        else{
            pane = sidePanel;
        }
        List<Trip> res = Arrays.asList(results);
        panel = new ResultsPanel(res);
        sPane = panel.Show();
        this.add(sPane);
        sPane.setSize(pane.getSize());
        sPane.setLocation(pane.getLocation());   
        this.validate();
        this.repaint();        
    }
    
    private void showInfo(Trip selectedRow) {
        JComponent pane;
        if(bookSPane != null){
            pane = bookSPane;
            this.remove(bookSPane);
        }
        else{
            pane = bookingsPanel;
        }
        bookButton.setVisible(true);
        bookButton.setEnabled(true);
        bookingsPanel.setVisible(false);
        bookingInfoPanel.setVisible(true);
        List<Trip> res = Arrays.asList(selectedRow);
        bookingPanel = new BookTripPanel(res);
        bookSPane = bookingPanel.Show();
        this.add(bookSPane);
        bookSPane.setSize(pane.getSize());
        bookSPane.setLocation(pane.getLocation());
        this.revalidate();
        this.repaint();
    }
    
    void showDialog(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sortButtons = new javax.swing.ButtonGroup();
        searchPanel = new javax.swing.JPanel();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bookingsButton = new javax.swing.JButton();
        infoPanel = new javax.swing.JPanel();
        infoButton = new javax.swing.JButton();
        nameButton = new javax.swing.JRadioButton();
        priceButton = new javax.swing.JRadioButton();
        timeButton = new javax.swing.JRadioButton();
        sortLabel = new javax.swing.JLabel();
        sidePanel = new javax.swing.JPanel();
        myndJLabel = new javax.swing.JLabel();
        bookingsPanel = new javax.swing.JPanel();
        bookingInfoPanel = new javax.swing.JPanel();
        bookButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        nrTravelersLabel = new javax.swing.JLabel();
        addressLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        hotelPickup = new javax.swing.JCheckBox();
        nrTravelers = new javax.swing.JSpinner();
        tcInfoButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Day Trip Search Engine");
        setBackground(new java.awt.Color(214, 217, 0));

        searchPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nameSearchBox.setToolTipText("Enter name...");

        areaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capital Area", "Eastern Region", "Southern Region", "Northern Region", "Western Region", "Highlands of Iceland", " " }));

        typeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Golden Circle", "Horse Trips", "Volcano", "Glaciers", "Beer Trips", "Food Trips" }));
        typeCombo.setActionCommand("");

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

        jLabel3.setText("Enter trip name:");

        jLabel4.setText("Enter keyword:");

        bookingsButton.setText("Bookings");
        bookingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(accessibleButton)
                                    .addComponent(familyFriendlyButton)
                                    .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(areaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(typeLabel))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(areaLabel)))
                        .addGap(39, 39, 39)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(searchPanelLayout.createSequentialGroup()
                                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addComponent(startTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(startTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(endTimeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(endTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58))
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(92, 92, 92))))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(searchPanelLayout.createSequentialGroup()
                                        .addComponent(nameSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(keyWordSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(searchPanelLayout.createSequentialGroup()
                                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(67, 67, 67)
                                        .addComponent(titleLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4)))
                                .addGap(0, 17, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addComponent(bookingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addComponent(titleLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(keyWordSearchBox)
                    .addComponent(nameSearchBox))
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(areaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(areaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(typeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(typeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(startTimeLabel)
                            .addComponent(startTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endTimeLabel)
                            .addComponent(endTimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(accessibleButton)
                        .addGap(11, 11, 11)
                        .addComponent(familyFriendlyButton)))
                .addGap(18, 18, 18)
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        infoPanel.setMaximumSize(new java.awt.Dimension(67, 82));
        infoPanel.setMinimumSize(new java.awt.Dimension(67, 82));

        infoButton.setText("More Information");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        sortButtons.add(nameButton);
        nameButton.setSelected(true);
        nameButton.setText("Name");
        nameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButtonActionPerformed(evt);
            }
        });

        sortButtons.add(priceButton);
        priceButton.setText("Price");
        priceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceButtonActionPerformed(evt);
            }
        });

        sortButtons.add(timeButton);
        timeButton.setText("Time");
        timeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeButtonActionPerformed(evt);
            }
        });

        sortLabel.setText("Sort by:");

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoButton, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(sortLabel)
                .addGap(18, 18, 18)
                .addComponent(nameButton)
                .addGap(18, 18, 18)
                .addComponent(priceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeButton)
                .addContainerGap())
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameButton)
                    .addComponent(priceButton)
                    .addComponent(timeButton)
                    .addComponent(sortLabel)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookingsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout bookingsPanelLayout = new javax.swing.GroupLayout(bookingsPanel);
        bookingsPanel.setLayout(bookingsPanelLayout);
        bookingsPanelLayout.setHorizontalGroup(
            bookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bookingsPanelLayout.setVerticalGroup(
            bookingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        bookButton.setText("Book!");
        bookButton.setEnabled(false);
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });

        nameLabel.setText("Name:");

        phoneLabel.setText("Phone number:");

        nrTravelersLabel.setText("Nr. of travelers:");

        addressLabel.setText("Address:");

        emailLabel.setText("Email:");

        hotelPickup.setText("Hotel Pickup");

        tcInfoButton.setText("Tour Company Information");
        tcInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tcInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bookingInfoPanelLayout = new javax.swing.GroupLayout(bookingInfoPanel);
        bookingInfoPanel.setLayout(bookingInfoPanelLayout);
        bookingInfoPanelLayout.setHorizontalGroup(
            bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bookingInfoPanelLayout.createSequentialGroup()
                        .addComponent(addressLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                        .addComponent(phoneLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookingInfoPanelLayout.createSequentialGroup()
                        .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                                .addComponent(emailLabel)
                                .addGap(108, 108, 108)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotelPickup)
                    .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                        .addComponent(nrTravelersLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nrTravelers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addComponent(bookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(tcInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        bookingInfoPanelLayout.setVerticalGroup(
            bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(phoneLabel)
                                .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLabel)
                                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nrTravelersLabel)
                                .addComponent(nrTravelers, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addressLabel)
                                .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(emailLabel)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(hotelPickup))))
                    .addGroup(bookingInfoPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(bookingInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tcInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bookingInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookingsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bookingInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            search();
        } catch (SQLException | ClassNotFoundException ex) {
            showDialog("This request could not be processed, please try again");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        
        // Get seleted Trip from ResultsPanel.
        Trip selectedRow = bookingPanel.getSelectedRow();
        if(selectedRow == null) {
            showDialog("No trip chosen!");
            return;
        }
        
        // A Trip has been selected, get booking info.
        int availablePlaces = selectedRow.getAvailablePlaces();
        int numberOfTravelers = Integer.parseInt(nrTravelers.getValue().toString());
        String name = nameTextField.getText();
        String address = addressTextField.getText();
        String phone = phoneTextField.getText();
        String email = emailTextField.getText();
        boolean hpickup = hotelPickup.isSelected();

        // Check booking info
        if(numberOfTravelers == 0 || name == "" || address == "" || email == "") {
            showDialog("Some fields have not been filled out!");
            return;
        }
        
        // If possible, book the Trip.
        if(availablePlaces > numberOfTravelers) {
            try {
                controller.bookTrip(
                        name,
                        Integer.parseInt(phone),
                        address,
                        email,
                        selectedRow,
                        numberOfTravelers,
                        hpickup,
                        true
                );
                showDialog("Trip booked!");
           } catch (ClassNotFoundException ex) {
            showDialog("Unfortunately the Trip could not be booked, please try again later.");
        }
        
        this.validate();
        this.repaint();
        } else {
            // Trip is full or inactive
            showDialog("Unfortunately the Trip you have chosen is either fully booked or inactive.");
        }
        
    }//GEN-LAST:event_bookButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        Trip selectedRow = panel.getSelectedRow();
        if(selectedRow != null) {
            showInfo(selectedRow);
        } else {
            showDialog("No Trip chosen!");
        }
    }//GEN-LAST:event_infoButtonActionPerformed

    private void timeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeButtonActionPerformed
        Trip[] sorted = controller.sortTripsByTime(results);
        showResults(sorted);
    }//GEN-LAST:event_timeButtonActionPerformed

    private void nameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButtonActionPerformed
        Trip[] sorted = controller.sortTripsByName(results);
        showResults(sorted);
    }//GEN-LAST:event_nameButtonActionPerformed

    private void priceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceButtonActionPerformed
        Trip[] sorted = controller.sortTripsByPrice(results);
        showResults(sorted);
    }//GEN-LAST:event_priceButtonActionPerformed

    private void tcInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tcInfoButtonActionPerformed
        TourCompanyWindow tcWindow;
        Trip selectedRow = bookingPanel.getSelectedRow();
        if(selectedRow == null) {
            showDialog("No Trip chosen!");
            return;
        }
        TourCompany TourCompany = selectedRow.getTourCompany();
        tcWindow = new TourCompanyWindow(TourCompany);
        tcWindow.setVisible(true); 
    }//GEN-LAST:event_tcInfoButtonActionPerformed

    private void bookingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingsButtonActionPerformed
        BookingsWindow bookWindow;
        TripController TripController = controller;
        bookWindow = new BookingsWindow(TripController);
        bookWindow.setVisible(true);
    }//GEN-LAST:event_bookingsButtonActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

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
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JRadioButton accessibleButton;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextField;
    private javax.swing.JComboBox<String> areaCombo;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JButton bookButton;
    private javax.swing.JPanel bookingInfoPanel;
    private javax.swing.JButton bookingsButton;
    private javax.swing.JPanel bookingsPanel;
    private datechooser.beans.DateChooserPanel dateChooser;
    private javax.swing.JMenu editMenu;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JSpinner endTimeSpinner;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JRadioButton familyFriendlyButton;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JCheckBox hotelPickup;
    private javax.swing.JButton infoButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JTextField keyWordSearchBox;
    private javax.swing.JLabel myndJLabel;
    private javax.swing.JRadioButton nameButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameSearchBox;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JSpinner nrTravelers;
    private javax.swing.JLabel nrTravelersLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JRadioButton priceButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel sidePanel;
    private javax.swing.ButtonGroup sortButtons;
    private javax.swing.JLabel sortLabel;
    private javax.swing.JLabel startTimeLabel;
    private javax.swing.JSpinner startTimeSpinner;
    private javax.swing.JButton tcInfoButton;
    private javax.swing.JRadioButton timeButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> typeCombo;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables

    private TourCompany getTourCompany() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}