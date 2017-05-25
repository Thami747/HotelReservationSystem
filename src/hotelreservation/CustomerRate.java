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
public class CustomerRate {
    
    public int getLakewoodRegularCustomerRate(boolean isWeekend) {
        int dayRate;
            if(isWeekend) {
                dayRate = 90;
            } else {
                dayRate = 110;
            }
        return  dayRate;
    }
    
    public int getBridgewoodRegularCustomerRate(boolean isWeekend) {
        int dayRate;
            if(isWeekend) {
                dayRate = 60;
            } else {
                dayRate = 160;
            }
        return  dayRate;
    }
    
    public int getRidgewoodRegularCustomerRate(boolean isWeekend) {
        int dayRate;
            if(isWeekend) {
                dayRate = 150;
            } else {
                dayRate = 220;
            }
        return  dayRate;
    }
    
    public int getLakewoodRewardCustomerRate(boolean isWeekend) {
        int dayRate;
            if(isWeekend) {
                dayRate = 80;
            } else {
                dayRate = 80;
            }
        return  dayRate;
    }
    
    public int getBridgewoodRewardCustomerRate(boolean isWeekend) {
        int dayRate;
            if(isWeekend) {
                dayRate = 50;
            } else {
                dayRate = 110;
            }
        return  dayRate;
    }
    
    public int getRidgewoodRewardCustomerRate(boolean isWeekend) {
        int dayRate;
            if(isWeekend) {
                dayRate = 40;
            } else {
                dayRate = 100;
            }
        return  dayRate;
    }
    
}
