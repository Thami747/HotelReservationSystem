/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelreservation;

import java.util.regex.*; 

/**
 *
 * @author thami
 */
public class HotelReservation {
    
    public String date1 = "";
    public String date2 = "";
    public String date3 = "";
    
    public boolean checkWeekday = false;
    public String customerType = "";
    
    public HotelReservation(String customerType, String date1, String date2, String date3) {
        this.customerType = customerType;
        this.date1 = date1;
        this.date2 = date2;
        this.date3 = date3;
        
    }
    
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getDate3() {
        return date3;
    }

    public void setDate3(String date3) {
        this.date3 = date3;
    }
    
    public boolean isWeekend(String day) {
        String[] weekend = {"sat", "sun"};
        boolean value = false;
        
        for (int y = 0; y < weekend.length; y++) {
//            System.out.println("array weekend " + weekend[y] + "   day  " + day);
            if (weekend[y].equals(day)) {
//                System.out.println("We have hit true guys");
                value = true;
            }
        }
        
//        System.out.println("Value for weekend" + value);
        return value;
    }
    
    public String getDayFromDate(String date) {
        //date format should be 26March2009(day)
        String day = date;
        Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(day);
        while(m.find()) {
//        System.out.println(m.group(1));
        day = m.group(1);
     } 
        return day;
    }

}
