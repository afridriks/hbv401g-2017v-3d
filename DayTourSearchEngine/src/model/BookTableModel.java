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
public class BookTableModel extends AbstractTableModel{
    
    private List<Trip> trips;
    private final String[] columns;
    
    public BookTableModel(List<Trip> tripsArray){
        super();
        trips = tripsArray;
        columns = new String[]{"Auðkenni", "Nafn", "Dagsetning", "Upphafstími", "Lokatími", "Lýsing", 
                               "Fjölskylduvænt", "Aðgengilegt", "Verð", "Tegund", "Staðsetning", 
                               "Nánari staðsetning", "Heildarfjödi ferðamanna", "Laus sæti", "Ferðafélag"};
    }

    @Override
    public int getRowCount() {
        return trips.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Trip trip = trips.get(rowIndex);
        switch(columnIndex){
            case 0 : return trip.getId();
            case 1 : return trip.getName();
            case 2 : return trip.getDate();
            case 3 : return trip.getStartTime();
            case 4 : return trip.getEndTime();
            case 5 : return trip.getDescription();
            case 6 : return trip.isFamilyFriendly();
            case 7 : return trip.isAccessible();
            case 8 : return trip.getPrice();
            case 9 : return trip.getType();
            case 10 : return trip.getArea();    
            case 11 : return trip.getLocation();
            case 12 : return trip.getMaxTravelers();
            case 13 : return trip.getAvailablePlaces();
            case 14 : return trip.getTourCompany().getName();
            default : return null;
        }
    }
    
    @Override
    public String getColumnName(int index){
        return columns[index];
    }
    
}
