/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thami
 */
public class HotelReservationRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String[] inputFromTextFile = readInputFromFile("file.txt").split(",");
            System.out.println(testInputFromUser(inputFromTextFile[0], inputFromTextFile[1], inputFromTextFile[2], inputFromTextFile[3]));
        } catch (IOException ex) {
            Logger.getLogger(HotelReservationRun.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String readInputFromFile(String fileName) throws FileNotFoundException, IOException {
        String inputFromTextFile;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            } 
            inputFromTextFile = sb.toString();
            System.out.println(inputFromTextFile);
        }
        
        return inputFromTextFile;
    }
    
    public static String testInputFromUser(String customerType, String date1, String date2, String date3) {
        
        int[] totalRatesForReservations = {0,0,0};
        
        //assuming that this array has an ordered list of hotels per rating where position 0 is the lowest rating and position 2 is the highest rating
        String[] hotel = {"Lakewood", "Bridgewood", "Ridgewood"};
        
        totalRatesForReservations[0] = getTotalForLakeWood(customerType, date1, date2, date3);
        totalRatesForReservations[1] = getTotalForBridgeWood(customerType, date1, date2, date3);
        totalRatesForReservations[2] = getTotalForRidgeWood(customerType, date1, date2, date3);
        
        if (totalRatesForReservations[0] < totalRatesForReservations[1] && totalRatesForReservations[0] < totalRatesForReservations[2]) {
            return hotel[0];
        } else if (totalRatesForReservations[1] < totalRatesForReservations[0] && totalRatesForReservations[1] < totalRatesForReservations[2]) {
            return hotel[1];
        } else if (totalRatesForReservations[2] < totalRatesForReservations[0] && totalRatesForReservations[2] < totalRatesForReservations[1]) {
            return hotel[2];  
        } else {
            return hotel[2];
        }
    }
    
    public static int getTotalForLakeWood(String customerType, String date1, String date2, String date3) {
        int dayRate1, dayRate2, dayRate3, totalReservation;
        
        CustomerRate customerRate = new CustomerRate(); 
        HotelReservation hotelReservation =  new HotelReservation(customerType, date1, date2, date3);
        
        if (hotelReservation.getCustomerType().equalsIgnoreCase("Regular Customer")) {
            dayRate1 = customerRate.getLakewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date1)));
            dayRate2 = customerRate.getLakewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date2)));
            dayRate3 = customerRate.getLakewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date3)));
        } else {
            dayRate1 = customerRate.getLakewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date1)));
            dayRate2 = customerRate.getLakewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date2)));
            dayRate3 = customerRate.getLakewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date3)));
        }
        
        totalReservation = dayRate1 + dayRate2 + dayRate3;
        return totalReservation;
    }
    
    public static int getTotalForBridgeWood(String customerType, String date1, String date2, String date3) {
        int dayRate1, dayRate2, dayRate3, totalReservation;
        
        CustomerRate customerRate = new CustomerRate();
        HotelReservation hotelReservation =  new HotelReservation(customerType, date1, date2, date3);
        
        if (hotelReservation.getCustomerType().equalsIgnoreCase("Regular Customer")) {
            dayRate1 = customerRate.getBridgewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date1)));
            dayRate2 = customerRate.getBridgewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date2)));
            dayRate3 = customerRate.getBridgewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date3)));
        } else {
            dayRate1 = customerRate.getBridgewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date1)));
            dayRate2 = customerRate.getBridgewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date2)));
            dayRate3 = customerRate.getBridgewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date3)));
        }
        
        totalReservation = dayRate1 + dayRate2 + dayRate3;
        return totalReservation;
    }
    
    public static int getTotalForRidgeWood(String customerType, String date1, String date2, String date3) {
        int dayRate1, dayRate2, dayRate3, totalReservation;
        
        CustomerRate customerRate = new CustomerRate();
        HotelReservation hotelReservation =  new HotelReservation(customerType, date1, date2, date3);
        
        if (hotelReservation.getCustomerType().equalsIgnoreCase("Regular Customer")) {
            dayRate1 = customerRate.getRidgewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date1)));
            dayRate2 = customerRate.getRidgewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date2)));
            dayRate3 = customerRate.getRidgewoodRegularCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date3)));
        } else {
            dayRate1 = customerRate.getRidgewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date1)));
            dayRate2 = customerRate.getRidgewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date2)));
            dayRate3 = customerRate.getRidgewoodRewardCustomerRate(hotelReservation.isWeekend(hotelReservation.getDayFromDate(date3)));
        }
        
        totalReservation = dayRate1 + dayRate2 + dayRate3;
        return totalReservation;
    }
    
}
