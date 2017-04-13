/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sigurlaug
 */
public class BookingsTableModel extends AbstractTableModel{
    
    private final List<Booking> bookings;
    private final String[] columns;
    
    public BookingsTableModel(List<Booking> bookings){
        super();
        this.bookings = bookings;
        columns = new String[]{"Booking ID", "Customer ID", "Trip ID", "Number of places booked", "Hotel pickup", "Active"};
    }

    @Override
    public int getRowCount() {
        return bookings.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking booking = bookings.get(rowIndex);
        switch(columnIndex){
            case 0 : return booking.getId();
            case 1 : return booking.getCustomer();
            case 2 : return booking.getTrip();
            case 3 : return booking.getNumTravelers();
            case 4 : return booking.isHotelPickup();
            case 5 : return booking.isActive();
            default : return null;
        }
    }
    
    @Override
    public String getColumnName(int index){
        return columns[index];
    }
    
}
