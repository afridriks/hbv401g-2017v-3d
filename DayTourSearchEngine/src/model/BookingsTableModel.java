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
        columns = new String[]{"Customer name", "Trip name", "Date", "Number of travelers", "Hotel pickup", "Active", "Travel Company"};
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
            case 0 : return booking.getCustomer().getName();
            case 1 : return booking.getTrip().getName();
            case 2 : return booking.getTrip().getDate();
            case 3 : return booking.getNumTravelers();
            case 4 : if(booking.isHotelPickup())
                        return "Yes";
                     else
                        return "No";
            case 5 : if(booking.isActive())
                        return "Yes";
                     else 
                        return "No";
            case 6 : return booking.getTrip().getTourCompany().getName();
            default : return null;
        }
    }
    
    @Override
    public String getColumnName(int index){
        return columns[index];
    }
    
}
