/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;

/**
 *
 * @author thami
 */
public class HotelReservationRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println(testInputFromUser("Regular Customer", "16Mar2009(mon)", "17Mar2009(tues)", "18Mar2009(wed)"));
        System.out.println(testInputFromUser("Regular Customer", "20Mar2009(fri)", "21Mar2009(sat)", "22Mar2009(sun)"));
        System.out.println(testInputFromUser("Rewards Customer", "26Mar2009(thur)", "27Mar2009(fri)", "28Mar2009(sat)"));
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
